import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TIME  {

    private List<TimeObserver> observers = new ArrayList<>();
    private boolean isOpen;
    private String Timer;
    private LocalTime startTime = LocalTime.of(8, 30); // 8:30 AM
    private LocalTime endTime = LocalTime.of(21, 30);  // 9:30PM
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
    
    public void addObserver(TimeObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(TimeObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers(String time, boolean isOpen) {
        for (TimeObserver observer : observers) {
            observer.onTimeChange(time, isOpen);
        }
    }

    public void StarDay(){


    System.out.println("Inicio del dia");
    LocalTime currentTime = startTime;
        while (currentTime.isBefore(endTime) || currentTime.equals(endTime)) {
            Timer = currentTime.format(formatter);
            System.out.println(Timer);
            currentTime = currentTime.plusMinutes(30); // Incrementar cada x minutos


            isOpen = currentTime.isAfter(LocalTime.of(9, 0)) && currentTime.isBefore(LocalTime.of(21, 0));
            notifyObservers(Timer, isOpen);

            try {
                Thread.sleep(1000); //tiempo de espera realizar de nuevo bucle
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Fin del dia.");
    }
    
}
