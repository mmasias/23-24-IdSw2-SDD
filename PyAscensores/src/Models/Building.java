package Models;

import java.util.ArrayList;
import java.util.Set;

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

    public ArrayList<Integer> getFloors() {
        return new ArrayList<>(this.floors);
    }

    public void addFloor(int floor) {
        this.floors.add(floor);
    }

    public void removeFloor(int floor) {
        this.floors.remove(floor);
    }

    public ArrayList<Integer> getElevators() {
        return new ArrayList<>(this.elevators);
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
