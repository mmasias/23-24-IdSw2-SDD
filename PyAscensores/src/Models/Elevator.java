package Models;

import Enums.Direction;

public class Elevator {

    private int Id;
    private int Capacity;
    private int CurrentFloor;
    private Direction CurrentDirection;
    private boolean Access;

    public Elevator(int id, int capacity, int currentFloor) {
        Id = id;
        Capacity = capacity;
        CurrentFloor = currentFloor;
        CurrentDirection = Direction.STOP;
        Access = true;
    }

    public int getId() {
        return Id;
    }

    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(int capacity) {
        Capacity = capacity;
    }

    public int getCurrentFloor() {
        return CurrentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        CurrentFloor = currentFloor;
    }

    public Direction getDirection() {
        return CurrentDirection;
    }

    public void setDirection(Direction direction) {
        CurrentDirection = direction;
    }

    public boolean getAccess() {
        return Access;
    }

    public void setAccess(boolean access) {
        Access = access;
    }

}
