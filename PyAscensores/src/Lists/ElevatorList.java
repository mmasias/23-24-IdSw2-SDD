package Lists;

import java.util.ArrayList;
import Models.Elevator;

public class ElevatorList {
    private ModelList<Elevator> elevators;

    public ElevatorList() {
        this.elevators = new ModelList<Elevator>();
    }

    public ArrayList<Elevator> index() {
        return this.elevators.index();
    }

    public Elevator get(int id) {
        return this.elevators.get(id);
    }

    public void create(int id, int capacity, int currentFloor) {
        this.elevators.add(new Elevator(id, capacity, currentFloor));
    }

    public void update(int id, Elevator updatedElevator) {
        this.elevators.update(id, updatedElevator);
    }

    public void delete(int id) {
        this.elevators.delete(id);
    }

    public void add(Elevator elevator) {
        this.elevators.add(elevator);
    }
}
