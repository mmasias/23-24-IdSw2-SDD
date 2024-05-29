package Controllers;

import Models.*;
import Views.BuildingView;
import java.util.Scanner;

public class Simulation {
    private BuildingController buildingController;
    private Values initialValues;
    private Time time;
    private Building building;

    public Simulation(Values values) {
        this.initialValues = values;
        this.time = new Time();
    }

    public void start(boolean isTesting) {
        setInitialValues();
        simulation(isTesting);
    }

    private void setInitialValues() {
        this.initialValues = new Values(5, 3);
        this.building = new Building(0);

        this.getInitialElevators();
        this.getInitialFloors();
        this.getInitialPeople();
        this.buildingController = new BuildingController(building);
    }

    private void getInitialElevators() {
        this.initialValues.setElevatorCapacity(6);
        int amountElevators = this.initialValues.getAmountElevators();

        for (int i = 0; i < amountElevators; i++) {
            int currentFloor = this.initialValues.getElevatorFloor();
            int capacity = this.initialValues.getElevatorCapacity();
            building.addElevator(capacity, currentFloor);
        }
    }

    private void getInitialFloors() {
        int amountFloors = this.initialValues.getAmountFloors();
        String label = this.initialValues.getLabel();

        for (int i = 0; i <= amountFloors; i++) {
            building.addFloor(label + i);
        }
    }

    private void getInitialPeople() {
        int amountPeople = this.initialValues.getAmountPeople(2, 10);

        for (int i = 0; i <= amountPeople; i++) {
            int timeOnFloor = this.initialValues.getRandomTimeOnFloor(0, 5);
            int currentFloor = this.initialValues.getRandomFloor();
            int destination = this.initialValues.getRandomFloor(currentFloor);

            building.addPersonOnFloor(timeOnFloor, currentFloor, destination);
        }
    }

    private void simulation(boolean isTesting) {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        new BuildingView(building, isTesting).render();
        input = scanner.nextLine();

        while (!input.equals("q")) {
            time.tickFloors(buildingController);
            new BuildingView(building, isTesting).render();
            input = scanner.nextLine();

            time.tickElevators(buildingController);
            new BuildingView(building, isTesting).render();
            input = scanner.nextLine();

            time.tickControlPanels(buildingController);
            new BuildingView(building, isTesting).render();
            input = scanner.nextLine();
        }
        scanner.close();
    }
}
