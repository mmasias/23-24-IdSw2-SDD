package Models;

import java.util.ArrayList;

import Enums.Direction;
import Lists.PersonList;

public class Elevator {
    private int id;
    private int capacity;
    private PersonList peopleInside;
    private int currentFloor;
    private Direction currentDirection;
    private boolean access;

    public Elevator(int id, int capacity, int currentFloor) {
        this.id = id;
        this.capacity = capacity;
        this.currentFloor = currentFloor;
        this.currentDirection = Direction.STOP;
        this.access = true;
        this.peopleInside = new PersonList();
    }

    public int getId() {
        return this.id;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCurrentFloor() {
        return this.currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Direction getDirection() {
        return this.currentDirection;
    }

    public void setDirection(Direction direction) {
        this.currentDirection = direction;
    }

    public boolean getAccess() {
        return this.access;
    }

    public void setAccess(boolean access) {
        this.access = access;
    }

    public ArrayList<Person> getPeopleInside() {
        return this.peopleInside.index();
    }

    public void addPeopleInside(Person newPerson) {
        this.peopleInside.add(newPerson);
    }
    public void deletePeopleInside(int id) {
        this.peopleInside.delete(id);
    }
}
