package Models;

import Enums.Directions;

public class Elevator {

    private int Id;
    private int Capacity = 0;
    private int CurrentFloor = 0;
    private Directions Direction = Directions.STOP;
    private boolean Access = true;

    public Elevator(int id, int capacity, int currentFloor, Directions direction, boolean access) {
        Id = id;
        Capacity = capacity;
        CurrentFloor = currentFloor;
        Direction = direction;
        Access = access;
    }

}
