package Models;

import java.util.ArrayList;

import Enums.Direction;
import Lists.PersonList;

public class Elevator implements IModel {
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

    public void removePeopleInside(int id) {
        this.peopleInside.delete(id);
    }

    public void updatePeopleInside(int id, Person updatedPerson) {
        this.peopleInside.update(id, updatedPerson);
    }

    public void createPersonInside(int id, int timeOnFloor, int currentFloor, int destination) {
        this.peopleInside.create(id, timeOnFloor, currentFloor, destination);
    }
}