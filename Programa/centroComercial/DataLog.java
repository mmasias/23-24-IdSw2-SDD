import java.util.ArrayList;
import java.util.List;

public class DataLog {
    private List<String> logEntries;
    private int totalCustomersServed;
    private int totalItemsSold;
    private int minutesWithZeroQueue;
    private int totalCashRegisterClosures = 0;

    public DataLog() {
        this.logEntries = new ArrayList<>();
        this.totalCustomersServed = 0;
        this.totalItemsSold = 0;
        this.minutesWithZeroQueue = 0;
    }

    public void logEvent(String event) {
        logEntries.add(event);
        System.out.println(event);
    }

    public void incrementCustomersServed() {
        totalCustomersServed++;
    }

    public void addItemsSold(int items) {
        totalItemsSold += items;
    }

    public void incrementMinutesWithZeroQueue() {
        minutesWithZeroQueue++;
    }

    public void registerCashRegisterClosure() {
        totalCashRegisterClosures++;
    }

    public void printStatistics(CustomerQueue queue) {
        System.out.println("======================================================================");
        System.out.println("RESUMEN");
        System.out.println("======================================================================");
        System.out.println("Minutos con cola en cero\t: " + minutesWithZeroQueue);
        System.out.println("Personas atendidas en el dia\t: " + totalCustomersServed);
        System.out.println("Artículos vendidos en el dia\t: " + totalItemsSold);
        System.out.println("Máximo número de clientes en cola: " + queue.getMaxQueueLength());
        System.out.println("Número de cierres de caja al día: " + totalCashRegisterClosures);
        System.out.println("======================================================================");
    }

    public List<String> getLogEntries() {
        return logEntries;
    }
}
