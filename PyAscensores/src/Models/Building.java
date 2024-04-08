package Models;

import java.util.List;

public class Building {
    List<Floor> Floor;
    List<Elevator> Elevator;
    boolean Access;
    int Capacity;

    public Building(List<Floor> floor, List<Elevator> elevator) {
        Floor = floor;
        Elevator = elevator;
        Access = true;
    }

    public void setAccess(boolean access) {
        Access = access;
    }

    public void setFloors(List<Floor> floor) {
        Floor = floor;
    }

    public void setElevators(List<Elevator> elevator) {
        Elevator = elevator;
    }

    public boolean getAccess() {
        return Access;
    }

    public List<Floor> getFloors() {
        return Floor;
    }

    public List<Elevator> getElevators() {
        return Elevator;
    }
}
