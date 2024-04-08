package Models;

import java.util.ArrayList;
import java.util.Set;

public class Building {
    Set<Integer> floors;
    Set<Integer> elevators;
    boolean access;
    int capacity;

    public Building(int capacity) {
        this.access = true;
        this.capacity = capacity;
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
