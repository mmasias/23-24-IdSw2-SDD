package src.Lists;

public class Counters {

    private int floorCounter;
    private int elevatorCounter;
    private int personCounter;
    private int controlPanelCounter;

    public Counters() {
        this.floorCounter = 0;
        this.elevatorCounter = 0;
        this.personCounter = 0;
        this.controlPanelCounter = 0;
    }

    public int getFloorCounter() {
        return this.floorCounter;
    }

    public int getElevatorCounter() {
        return this.elevatorCounter;
    }

    public int getPersonCounter() {
        return this.personCounter;
    }

    public int getControlPanelCounter() {
        return this.controlPanelCounter;
    }

    public void incrementFloorCounter() {
        this.floorCounter++;
    }

    public void incrementElevatorCounter() {
        this.elevatorCounter++;
    }

    public void incrementPersonCounter() {
        this.personCounter++;
    }
}
