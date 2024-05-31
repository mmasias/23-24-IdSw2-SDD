package src.Models;

public class Person implements IModel {
    private int id;
    private int timeOnFloor;
    private int destination;

    public Person(int id, int timeOnFloor, int destination) {
        this.id = id;
        this.timeOnFloor = timeOnFloor;
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

    public int getDestination() {
        return this.destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }
}