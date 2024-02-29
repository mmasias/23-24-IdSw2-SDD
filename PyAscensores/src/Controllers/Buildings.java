package Controllers;

import java.util.ArrayList;

import Models.Elevator;
import Models.Floor;
import Models.Building;

public class Buildings {

    private static Building Building = new Building(null, null);

    public static void createBuilding() {
        int amountFloors = InitialValues.getAmountFloors();
        int amountElevators = InitialValues.getAmountElevators();
        int elevatorCapacity = InitialValues.getElevatorCapacity();
        int elevatorFloor = InitialValues.getElevatorFloor();
        String label = InitialValues.getLabel();

        ArrayList<Floor> floors = Floors.createFloors(amountFloors, label);
        ArrayList<Elevator> elevators = Elevators.createElevators(amountElevators, elevatorCapacity, elevatorFloor);

        Building.setFloors(floors);
        Building.setElevators(elevators);
    }

    public static Building getBuilding() {
        return Building;
    }

}
