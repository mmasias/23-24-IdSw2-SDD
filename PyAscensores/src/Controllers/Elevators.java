package Controllers;

import java.util.ArrayList;
import Models.Elevator;

public class Elevators {
    private static ArrayList<Elevator> Elevators = new ArrayList<Elevator>();

    public static ArrayList<Elevator> createElevators(int amount, int capacity, int currentFloor) {
        for (int i = 0; i < amount; i++) {
            Elevator elevator = new Elevator(i, capacity, currentFloor);
            Elevators.add(elevator);
        }
        return Elevators;
    }

    public static ArrayList<Elevator> index() {
        return Elevators;
    }

    public static Elevator get(int id) {
        return Elevators.get(id);
    }

    public static void update(int id, int amount, int capacity, int currentFloor) {
        Elevators.get(id).setCapacity(capacity);
        Elevators.get(id).setCurrentFloor(currentFloor);
        Elevators.get(id).setPeopleInside(amount);

    }

    public static void delete(int id) {
        Elevators.remove(Elevators.get(id));

    }

}
