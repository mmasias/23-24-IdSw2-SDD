import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ShoppingCenter {

    // Variable compartida
    private static volatile boolean isOpen = false;
    private static volatile String Timer = "";

    public static void main(String[] args) {

        new Thread(() -> {
            LocalTime startTime = LocalTime.of(8, 30); // 8:30 AM
            LocalTime endTime = LocalTime.of(21, 30);  // 9:30PM
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
            System.out.println("Inicio del dia.");
            LocalTime currentTime = startTime;
            while (currentTime.isBefore(endTime) || currentTime.equals(endTime)) {
                Timer = currentTime.format(formatter);
                System.out.println(Timer);
                currentTime = currentTime.plusMinutes(30); // Incrementar cada 30 minutos

                
                isOpen = currentTime.isAfter(LocalTime.of(9, 0)) && currentTime.isBefore(LocalTime.of(21, 0));

                try {
                    Thread.sleep(1000); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Fin del dia.");
        }).start();

        
        new Thread(() -> {
            
                try {
                    Thread.sleep(1100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (isOpen) {
                    System.out.println("Centro comercial abierto, abriendo cajas");
                }

                while (isOpen) {
                    
                    //CashRegister cashRegister = new CashRegister();
                    //int[] idcaja = cashRegister.GetIdOpenned();
                    //for (int id : idcaja) {
                        //System.out.println("caja[" + id + "] abierta");
                    //}

                }
                try {
                    Thread.sleep(1100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Centro comercial cerrando, cerrando cajas");
        }).start();
    }
}


