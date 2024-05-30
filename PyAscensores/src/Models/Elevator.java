package Models;

import java.util.ArrayList;

import Enums.Direction;
import Lists.FloorsToGoList;
import Lists.PersonList;

public class Elevator implements IModel {
    private int id;
    private int capacity;
    private PersonList peopleInside;
    private int currentFloor;
    private Direction currentDirection;
    private FloorsToGoList floorsToGoList;

    public Elevator(int id, int capacity, int currentFloor) {
        this.id = id;
        this.capacity = capacity;
        this.currentFloor = currentFloor;
        this.currentDirection = Direction.STOP;
        this.peopleInside = new PersonList();
        this.floorsToGoList = new FloorsToGoList();
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

    public boolean isFull() {
        return this.peopleInside.index().size() == this.capacity;
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

    public FloorsToGoList getFloorsToGoList() {
        return this.floorsToGoList;
    }

    public void addFloorToGo(int floor, Direction direction, int currentFloor) {
        this.floorsToGoList.add(floor, direction, currentFloor);
    }

    public void removeFloorToGo(int floor) {
        this.floorsToGoList.delete(floor);
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
}