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
        this.addInitialElevators(building);
        this.addInitialFloors(building);
        this.addInitialPeople(building);
    }

    private void addInitialElevators(Building building) {
        int amountElevators = this.initialValues.getAmountElevators();
        for (int i = 0; i < amountElevators; i++) {
            int currentFloor = this.initialValues.getElevatorFloor();
            int capacity = this.initialValues.getElevatorCapacity();
            building.addElevator(capacity, currentFloor);
        }
    }

    private void addInitialFloors(Building building) {
        int amountFloors = this.initialValues.getAmountFloors();
        String label = this.initialValues.getLabel();
        for (int i = 0; i < amountFloors; i++) {
            building.addFloor(label + i);
        }
    }

    private void addInitialPeople(Building building) {
        int amountPeople = this.initialValues.getAmountPeople(2, 10);
        for (int i = 0; i <= amountPeople; i++) {
            int timeOnFloor = this.initialValues.getRandomTimeOnFloor(0, 10);
            int currentFloor = this.initialValues.getRandomFloor();
            int destination = this.initialValues.getRandomFloor(currentFloor);
            building.addPersonOnFloor(timeOnFloor, currentFloor, destination);
        }
    }

    public BuildingController createBuildingController(Building building) {
        return new BuildingController(building);
    }
}
