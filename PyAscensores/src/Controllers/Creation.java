package Controllers;

import Models.Building;

public class Creation {
    private Values initialValues;

    public Creation(Values initialValues) {
        this.initialValues = initialValues;
    }

    public Building createBuilding() {
        Building building = new Building(0);
        setInitialValues(building);
        return building;
    }

    private void setInitialValues(Building building) {
        initialValues.setElevatorCapacity(6);
        addInitialElevators(building);
        addInitialFloors(building);
        addInitialPeople(building);
    }

    private void addInitialElevators(Building building) {
        int amountElevators = initialValues.getAmountElevators();
        for (int i = 0; i < amountElevators; i++) {
            int currentFloor = initialValues.getElevatorFloor();
            int capacity = initialValues.getElevatorCapacity();
            building.addElevator(capacity, currentFloor);
        }
    }

    private void addInitialFloors(Building building) {
        int amountFloors = initialValues.getAmountFloors();
        String label = initialValues.getLabel();
        for (int i = 0; i < amountFloors; i++) {
            building.addFloor(label + i);
        }
    }

    private void addInitialPeople(Building building) {
        int amountPeople = initialValues.getAmountPeople(2, 10);
        for (int i = 0; i <= amountPeople; i++) {
            int timeOnFloor = initialValues.getRandomTimeOnFloor(0, 5);
            int currentFloor = initialValues.getRandomFloor();
            int destination = initialValues.getRandomFloor(currentFloor);
            building.addPersonOnFloor(timeOnFloor, currentFloor, destination);
        }
    }

    public BuildingController createBuildingController(Building building) {
        return new BuildingController(building);
    }
}
