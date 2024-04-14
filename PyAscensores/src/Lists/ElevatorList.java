package Lists;

import java.util.ArrayList;
import Models.Elevator;

public class ElevatorList {
    private ArrayList<Elevator> elevators;
    private int counter;

    public ElevatorList() {
        this.elevators = new ArrayList<Elevator>();
        this.counter = 0;
    }

    public ArrayList<Elevator> index() {
        return this.elevators;
    }

    public Elevator get(int id) {
        if (id >= 0 && id <= this.counter) {
            for (Elevator elevator : this.elevators) {
                if (elevator.getId() == id) {
                    return elevator;
                }
            }
        }
        return null;
    }

    public void create(int capacity, int currentFloor) {
        this.elevators.add(new Elevator(this.counter, capacity, currentFloor));
        this.counter++;
    }

    public void update(int id, Elevator updatedElevator) {
        if (id >= 0 && id <= this.counter) {
            this.elevators.set(id, updatedElevator);
        }
    }

    public void delete(int id) {
        if (id >= 0 && id <= this.elevators.size()) {
            this.elevators.remove(id);
        }
    }
}
