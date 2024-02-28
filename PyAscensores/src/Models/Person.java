package Models;

public class Person implements IModel {
    private int timeOnFloor;
    private int position;
    private int destination;

    public Person(int timeOnFloor, int position, int destination) {
        this.timeOnFloor = timeOnFloor;
        this.position = position;
        this.destination = destination;
    }

    public int getTimeOnFloor() {
        return timeOnFloor;
    }

    public void setTimeOnFloor(int timeOnFloor) {
        this.timeOnFloor = timeOnFloor;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }
}
