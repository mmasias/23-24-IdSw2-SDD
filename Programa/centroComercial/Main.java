import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Inicialización del centro comercial, colas y cajas registradoras
        ShoppingCenter shoppingCenter = new ShoppingCenter("09:00", "20:40");
        CustomerQueue queue = new CustomerQueue();
        List<Cashier> cashiers = loadCashiers("./cashiers.json");
        int maxCashRegisters = 6; // Límite de 5 cajas registradoras
        CashRegister[] cashRegisters = new CashRegister[maxCashRegisters];
        DataLog dataLog = new DataLog();
        AttentionCenter attentionCenter = new AttentionCenter(queue, cashRegisters, cashiers, dataLog);

        // Asignar cajeros a sus respectivas cajas
        for (int i = 0; i < maxCashRegisters; i++) {
            cashRegisters[i] = new CashRegister(i + 1, attentionCenter);
            cashRegisters[i].setCurrentCashier(cashiers.get(i));
        }

        Time time = new Time(8, 55); // Configurar hora inicial antes de la apertura
        boolean spawnCustomers = true;

        // Bucle principal de la simulación
        while (true) {
            String currentTime = time.getCurrentTime();
            shoppingCenter.updateStatus(currentTime); // Actualizar el estado de apertura/cierre

            if (shoppingCenter.isOpen()) {
                // Generar nuevos clientes de manera aleatoria
                if (Math.random() <= 0.45 && spawnCustomers) {
                    Customer newCustomer = new Customer((int) (Math.random() * 1000), (int) (Math.random() * 10) + 5);
                    shoppingCenter.addCustomer(newCustomer);
                    queue.addCustomer(newCustomer);
                    dataLog.incrementCustomersServed(); // Registrar nuevo cliente
                    dataLog.addItemsSold(newCustomer.getNumberOfItemPacks()); // Registrar ventas
                    attentionCenter.updateOpenMinutes();
                }
                if (queue.getSize() == 0) {
                    dataLog.incrementMinutesWithZeroQueue();
                }

                // Manejo de descansos, cambios de turno y asignación de clientes
                attentionCenter.checkAndInitiateBreaks(currentTime);
                attentionCenter.handleShiftChanges(currentTime);
                attentionCenter.assignCustomersToCashRegisters();
                attentionCenter.processCustomersInCashRegisters(shoppingCenter);

                // Cerrar cajas no necesarias
                if (spawnCustomers) {
                    attentionCenter.closeCashRegisters();
                }

                // Manejar los descansos y posibles reaperturas de cajas
                for (CashRegister cashRegister : attentionCenter.getCashRegisters()) {
                    if (!cashRegister.isOpen() && cashRegister.getBreakCounter() > 0) {
                        cashRegister.setBreakCounter(cashRegister.getBreakCounter() - 1);
                        if (cashRegister.getBreakCounter() == 0) {
                            cashRegister.endBreak();
                        }
                    }
                }
            }

            // Registro de estado cada minuto
            if (time.getMinute() % 1 == 0) {
                printCurrentState(shoppingCenter, queue, attentionCenter, currentTime);
            }

            time.incrementTime(); // Avanzar el tiempo

            try {
                Thread.sleep(5); // Simular tiempo real
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Condiciones de cierre
            if (currentTime.equals("21:00")) {
                System.out.println("PUERTAS CERRADAS");
                spawnCustomers = false;
            }

            if (!spawnCustomers && shoppingCenter.getCustomersInside().size() <= 0) {
                shoppingCenter.closeCenter();
                dataLog.printStatistics(queue); // Imprimir estadísticas al cerrar
                break;
            }
        }
    }

    private static List<Cashier> loadCashiers(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            Gson gson = new Gson();
            Type cashierListType = new TypeToken<List<Cashier>>() {
            }.getType();
            return gson.fromJson(reader, cashierListType);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void printCurrentState(ShoppingCenter shoppingCenter, CustomerQueue queue,
            AttentionCenter attentionCenter, String currentTime) {
        System.out.println("=====================================================================");
        System.out.println(currentTime + " - Estado actual del Supermercado");
        System.out.println("Clientes totales: " + shoppingCenter.getCustomersInside().size() + " - En Cola: "
                + queue.getSize() + " - En Caja: " + getTotalCustomersInCashRegisters(attentionCenter));
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");

        System.out.println("Clientes dentro de Supermercado:");
        if (shoppingCenter.getCustomersInside().isEmpty()) {
            System.out.print("[-]");
        } else {
            for (Customer customer : shoppingCenter.getCustomersInside()) {
                System.out.print("[Cliente" + customer.getId() + ": " + customer.getNumberOfItemPacks() + "]");
            }
        }
        System.out.println();
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");

        System.out.println("Clientes en cola:");
        if (queue.getSize() == 0) {
            System.out.print("[-]");
        } else {
            for (Customer customer : queue.getCustomers()) {
                System.out.print("[Cliente" + customer.getId() + ": " + customer.getNumberOfItemPacks() + "]");
            }
        }
        System.out.println();
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");

        CashRegister[] cashRegisters = attentionCenter.getCashRegisters();
        for (CashRegister cashRegister : cashRegisters) {
            if (cashRegister.isOccupied()) {
                System.out.println("CAJA" + cashRegister.getId() + " : [" + cashRegister.getCurrentCashier().getName()
                        + "] | Cliente" + cashRegister.getCurrentCustomer().getId() + " ["
                        + cashRegister.getCurrentCustomer().getNumberOfItemPacks() + "]");
            } else if (cashRegister.isOpen()) {
                System.out.println(
                        "CAJA" + cashRegister.getId() + " : [" + cashRegister.getCurrentCashier().getName() + "]");
            } else if (cashRegister.getBreakCounter() > 0) {
                System.out.println(
                        "CAJA" + cashRegister.getId() + " : [DESCANSO " + cashRegister.getBreakCounter() + " mins]");
            } else {
                System.out.println("CAJA" + cashRegister.getId() + " : [CERRADA]");
            }
        }
        System.out.println("=====================================================================");
    }

    private static int getTotalCustomersInCashRegisters(AttentionCenter attentionCenter) {
        int total = 0;
        for (CashRegister cashRegister : attentionCenter.getCashRegisters()) {
            if (cashRegister.isOccupied()) {
                total++;
            }
        }
        return total;
    }
}
