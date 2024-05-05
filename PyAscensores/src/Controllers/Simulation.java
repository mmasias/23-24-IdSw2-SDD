package Controllers;

import java.util.ArrayList;
import Models.*;
import Lists.BuildingList;
import Views.BuildingView;
import java.util.Scanner;

public class Simulation {
    private BuildingController buildingController;
    private InitialValues initialValues;
    private Time time;

    public Simulation(InitialValues values) {
        this.initialValues = values;
        this.time = new Time();
    }

    public void start() {
        setInitialValues();
        simulation();
    }

    private void setInitialValues() {
        this.initialValues = new InitialValues(5, 3);
        BuildingList buildingList = new BuildingList();
        buildingList.create(0);

        this.getInitialElevators(buildingList);
        this.getInitialFloors(buildingList);
        this.getInitialPeople(buildingList);
        this.buildingController = new BuildingController(buildingList);
    }

    private void getInitialElevators(BuildingList buildingList) {
        this.initialValues.setElevatorCapacity(6);
        int amountElevators = this.initialValues.getAmountElevators();

        for (int i = 0; i < amountElevators; i++) {
            int currentFloor = this.initialValues.getElevatorFloor();
            int capacity = this.initialValues.getElevatorCapacity();
            buildingList.get(0).addElevator(capacity, currentFloor);
        }
    }

    private void getInitialFloors(BuildingList buildingList) {
        int amountFloors = this.initialValues.getAmountFloors();
        String label = this.initialValues.getLabel();

        for (int i = 0; i <= amountFloors; i++) {
            buildingList.get(0).addFloor(label + i);
        }
    }

    private void getInitialPeople(BuildingList buildingList) {
        int amountPeople = this.initialValues.getAmountPeople();

        for (int i = 0; i <= amountPeople; i++) {
            int timeOnFloor = this.initialValues.getRandomTimeOnFloor(0, 8);
            int currentFloor = this.initialValues.getRandomFloor();
            int destination = this.initialValues.getRandomFloor();
            int position = this.initialValues.randomInt(1, 3);

            if (position == 1) {
                this.addPersonToRandomElevator(buildingList, timeOnFloor, currentFloor, destination);
            } else if (position == 2) {
                this.addPersonToRandomFloor(buildingList, timeOnFloor, currentFloor, destination);
            } else if (position == 3) {
                this.addWaitingPersonToRandomFloor(buildingList, timeOnFloor, currentFloor, destination);
            }
        }
    }

    private void addPersonToRandomElevator(BuildingList buildingList, int timeOnFloor, int currentFloor,
            int destination) {
        int elevatorId = this.initialValues.randomInt(0, buildingList.get(0).getElevators().size() - 1);
        buildingList.get(0).addPersonInElevator(elevatorId, timeOnFloor, currentFloor, destination);
    }

    private void addPersonToRandomFloor(BuildingList buildingList, int timeOnFloor, int currentFloor, int destination) {
        int floorId = this.initialValues.randomInt(0, buildingList.get(0).getFloors().size() - 1);
        buildingList.get(0).addPersonOnFloor(floorId, timeOnFloor, currentFloor, destination);
    }

    private void addWaitingPersonToRandomFloor(BuildingList buildingList, int timeOnFloor, int currentFloor,
            int destination) {
        int floorId = this.initialValues.randomInt(0, buildingList.get(0).getFloors().size() - 1);
        buildingList.get(0).addWaitingPersonOnFloor(floorId, timeOnFloor, currentFloor, destination);
    }

    private void simulation() {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        while (!input.equals("q")) {
            ArrayList<Building> buildings = time.tick(buildingController);
            new BuildingView(buildings).render();
            input = scanner.nextLine();
        }
        scanner.close();
    }
}
