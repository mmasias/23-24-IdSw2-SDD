package Models;

import java.util.List;

public class Building implements IModel {
    List<Floor> _floor;
    List<Elevator> _elevator;
    boolean _access;
    int _capacity;

    public Building(List<Floor> floor, List<Elevator> elevator) {
        _floor = floor;
        _elevator = elevator;
        _access = true;
    }

    // region Setters
    public void SetAccess(boolean access) {
        _access = access;
    }

    public void SetFloors(List<Floor> floor) {
        _floor = floor;
    }

    public void SetElevators(List<Elevator> elevator) {
        _elevator = elevator;
    }
    // endregion

    // region Getters
    public boolean GetAccess() {
        return _access;
    }

    public List<Floor> GetFloors() {
        return _floor;
    }

    public List<Elevator> GetElevators() {
        return _elevator;
    }

    // endregion
}
