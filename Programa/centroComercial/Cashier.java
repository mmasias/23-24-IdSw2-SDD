public class Cashier {
    private int id;
    private String name;
    private String workShift;
    private String workBreak;
    private boolean isServing;

    public Cashier(int id, String name, String workShift, String workBreak) {
        this.id = id;
        this.name = name;
        this.workShift = workShift;
        this.workBreak = workBreak;
        this.isServing = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorkShift() {
        return workShift;
    }

    public void setWorkShift(String workShift) {
        this.workShift = workShift;
    }

    public String getWorkBreak() {
        return workBreak;
    }

    public void setWorkBreak(String workBreak) {
        this.workBreak = workBreak;
    }

    public boolean isServing() {
        return isServing;
    }

    public void setServing(boolean serving) {
        isServing = serving;
    }

    public void startShift() {
        this.isServing = true;
        System.out.println("Cashier " + this.name + " has started their shift.");
    }

    public void endShift() {
        this.isServing = false;
        System.out.println("Cashier " + this.name + " has ended their shift.");
    }
}
