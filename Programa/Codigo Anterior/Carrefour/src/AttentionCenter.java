
public class AttentionCenter implements TimeObserver {

    public  void onTimeChange(String time, boolean allOpen){

        Queue customerQueue = Queue.getInstance(); // Obtiene la instancia de la cola

        while (customerQueue.GetSize() > 0) {
            
            Customer customer = customerQueue.Dequeue(); // Extrae un cliente de la cola
            CashRegister availableRegister = findAvailableRegister();
            if (availableRegister != null) {
                availableRegister.remainingPacks = customer.numberOfPacks;
            } 
            if (customerQueue.GetSize()> 15) {
                availableRegister.OpenNewCash();
            } else {
                System.out.println("No hay cajas disponibles en este momento.");
                break; // Sale del bucle si no hay cajas disponibles
            }
        }
    }

    private CashRegister findAvailableRegister() {
        for (CashRegister register : CashRegister.lRegisters) {
            if (!register.isOccupied && register.isOpen) {
                
                return register;
            }
        }
        return null; // Retorna null si no hay cajas libres
    }
}

