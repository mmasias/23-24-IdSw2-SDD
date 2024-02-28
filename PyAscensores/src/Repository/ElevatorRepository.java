package Repository;

import Models.Elevator;
import java.util.ArrayList;

public class ElevatorRepository implements IRepository {

    private static ArrayList<Elevator> Elevators = new ArrayList<Elevator>();

    public static Elevator create(int capacity, int currentFloor) {
        Elevator elevator = new Elevator(Elevators.size(), capacity, currentFloor);
        Elevators.add(elevator);
        return elevator;
    }

    public static Elevator read(int id) {
        return Elevators.get(id);
    }

    public static ArrayList<Elevator> readAll() {
        return Elevators;
    }

    public static Elevator update(Elevator model) {
        // TODO: Implement this method
        return null;
    }

    public static Elevator delete(int id) {
        // TODO: Implement this method
        return null;
    }

}
