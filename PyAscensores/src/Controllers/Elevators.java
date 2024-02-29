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

    public static ArrayList<Elevator> getElevators() {
        return Elevators;
    }

}
