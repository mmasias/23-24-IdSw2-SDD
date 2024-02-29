package Models;

public class Person implements IModel {
    private int timeOnFloor;
    private int currentFloor;
    private int destination;

    public Person(int timeOnFloor, int currentFloor, int destination) {
        this.timeOnFloor = timeOnFloor;
        this.currentFloor = currentFloor;
        this.destination = destination;
    }

    public int getTimeOnFloor() {
        return timeOnFloor;
    }

    public void setTimeOnFloor(int timeOnFloor) {
        this.timeOnFloor = timeOnFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int floorId) {
        this.currentFloor = floorId;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }
}
