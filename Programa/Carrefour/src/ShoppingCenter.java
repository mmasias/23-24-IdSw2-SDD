import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ShoppingCenter {

    // Variable compartida
    private static volatile boolean isOpen = false;
    private static volatile String Timer = "";

    public static void main(String[] args) {

        new Thread(() -> {
            LocalTime startTime = LocalTime.of(8, 30); // 8:30 AM
            LocalTime endTime = LocalTime.of(21, 0);  // 9:00 PM
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
            System.out.println("Contador desde las 8:30 AM hasta las 9:00 PM:");
            LocalTime currentTime = startTime;
            while (currentTime.isBefore(endTime) || currentTime.equals(endTime)) {
                Timer = currentTime.format(formatter);
                System.out.println(Timer);
                currentTime = currentTime.plusMinutes(30); // Incrementar cada 30 minutos

                // Actualizar isOpen basado en el tiempo actual
                isOpen = currentTime.isAfter(LocalTime.of(9, 0)) && currentTime.isBefore(LocalTime.of(21, 0));

                try {
                    Thread.sleep(10000); // Simular espera
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // Simular otras tareas que necesitan conocer el estado de isOpen
        new Thread(() -> {
            
                try {
                    Thread.sleep(11000); // Espera entre verificaciones
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (isOpen) {
                    System.out.println("Centro comercial abierto, abriendo cajas");
                } else {
                    System.out.println("Centro comercial cerrado, esperando...");
                }
            
        }).start();
    }
}


