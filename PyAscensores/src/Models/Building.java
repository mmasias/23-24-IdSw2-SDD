package Models;

import java.util.ArrayList;
import java.util.Set;
import Controllers.Floors;
import Controllers.Elevators;

public class Building {
    private int id;
    private Set<Integer> floors;
    private Set<Integer> elevators;
    private boolean access;
    private int capacity;

    public Building(int id, int capacity) {
        this.id = id;
        this.access = true;
        this.capacity = capacity;
    }

    public int getId() {
        return this.id;
    }

    public ArrayList<Floor> getFloors() {
        ArrayList<Floor> floors = new ArrayList<>();
        for (int floor : this.floors) {
            floors.add(Floors.get(floor));
        }
        return floors;
    }

    public void addFloor(int floor) {
        this.floors.add(floor);
    }

    public void removeFloor(int floor) {
        this.floors.remove(floor);
    }

    public ArrayList<Elevator> getElevators() {
        ArrayList<Elevator> elevators = new ArrayList<>();
        for (int elevator : this.elevators) {
            elevators.add(Elevators.get(elevator));
        }
        return elevators;
    }

    public void addElevator(int elevator) {
        this.elevators.add(elevator);
    }

    public void removeElevator(int elevator) {
        this.elevators.remove(elevator);
    }

    public boolean getAccess() {
        return this.access;
    }

    public void setAccess(boolean access) {
        this.access = access;
    }
}
