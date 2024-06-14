import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataLog {
    private List<String> logEntries;
    private int totalCustomersServed;
    private int totalItemsSold;
    private int minutesWithZeroQueue;
    private int totalCashRegisterClosures = 0;
    private Map<Integer, Integer> openMinutesPerCashRegister = new HashMap<>();

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

    public void incrementOpenMinutes(int cashRegisterId) {
        openMinutesPerCashRegister.put(cashRegisterId, openMinutesPerCashRegister.getOrDefault(cashRegisterId, 0) + 1);
    }

    public void printStatistics(CustomerQueue customerQueue) {
        System.out.println("======================================================================");
        System.out.println("RESUMEN");
        System.out.println("======================================================================");
        System.out.println("Minutos con cola en cero\t: " + minutesWithZeroQueue);
        System.out.println("Personas atendidas en el dia\t: " + totalCustomersServed);
        System.out.println("Artículos vendidos en el dia\t: " + totalItemsSold);
        System.out.println("Máximo número de clientes en cola: " + customerQueue.getMaxQueueLength());
        System.out.println("Número de cierres de caja al día: " + totalCashRegisterClosures);
        openMinutesPerCashRegister.forEach((id, minutes) -> {
            System.out.println("Minutos abiertos para la caja " + id + ": " + minutes);
        });
        System.out.println("======================================================================");
    }

    public List<String> getLogEntries() {
        return logEntries;
    }
}
