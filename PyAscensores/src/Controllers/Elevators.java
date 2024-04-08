package Controllers;

import java.util.ArrayList;
import Models.Elevator;

public class Elevators {
    private static ArrayList<Elevator> elevators = new ArrayList<Elevator>();

    public static ArrayList<Elevator> index() {
        return elevators;
    }

    public static Elevator get(int id) {
        if (id >= 0 && id < elevators.size()) {
            return elevators.get(id);
        }
        return null;
    }

    public static void create(int capacity, int currentFloor) {
        elevators.add(new Elevator(elevators.size(), capacity, currentFloor));
    }

    public static void update(int id, Elevator updatedElevator) {
        if (id >= 0 && id < elevators.size()) {
            elevators.set(id, updatedElevator);
        }
    }

    public static void delete(int id) {
        if (id >= 0 && id < elevators.size()) {
            elevators.remove(id);
        }
    }

}
