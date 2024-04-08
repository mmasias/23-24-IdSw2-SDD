package Controllers;

import java.util.ArrayList;

import Models.Elevator;
import Models.Floor;
import Models.Building;

public class Buildings {

    private ArrayList<Building> buildings;

    public Buildings() {
        this.buildings = new ArrayList<Building>();
    }

    public void create() {
        int amountFloors = InitialValues.getAmountFloors();
        int amountElevators = InitialValues.getAmountElevators();
        int elevatorCapacity = InitialValues.getElevatorCapacity();
        int elevatorFloor = InitialValues.getElevatorFloor();
        String label = InitialValues.getLabel();

        ArrayList<Floor> floors = Floors.createFloors(amountFloors, label);
        ArrayList<Elevator> elevators = Elevators.createElevators(amountElevators, elevatorCapacity, elevatorFloor);

        this.buildings.add(new Building(floors, elevators));
    }

    public Building get(int id) {
        if (id >= 0 && id < buildings.size()) {
            return this.buildings.get(id);
        }
        return null;
    }

    public void update(int id, Building updatedBuilding) {
        if (id >= 0 && id < buildings.size()) {
            this.buildings.set(id, updatedBuilding);
        }
    }

    public void delete(int id) {
        if (id >= 0 && id < buildings.size()) {
            this.buildings.remove(id);
        }
    }

    public ArrayList<Building> index() {
        return this.buildings;
    }
}
