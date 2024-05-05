package Models;

public class Person implements IModel {
    private int id;
    private int timeOnFloor;
    private int currentFloor;
    private int destination;

    public Person(int id, int timeOnFloor, int currentFloor, int destination) {
        this.id = id;
        this.timeOnFloor = timeOnFloor;
        this.currentFloor = currentFloor;
        this.destination = destination;
    }

    public int getId() {
        return this.id;
    }

    public int getTimeOnFloor() {
        return this.timeOnFloor;
    }

    public void setTimeOnFloor(int timeOnFloor) {
        this.timeOnFloor = timeOnFloor;
    }

    public int getCurrentFloor() {
        return this.currentFloor;
    }

    public void setCurrentFloor(int floorId) {
        this.currentFloor = floorId;
    }

    public int getDestination() {
        return this.destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }
}
