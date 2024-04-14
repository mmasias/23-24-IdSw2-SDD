package Controllers;

import java.util.ArrayList;
import Models.*;
import Lists.BuildingList;
import Views.BuildingView;
import java.util.Scanner;

public class Simulation {
    private BuildingController buildingController;
    private InitialValues initalVaules;
    private Time time;

    public Simulation() {
        this.buildingController = null;
        this.initalVaules = null;
        this.time = new Time();
    }

    public void start() {
        setInitialValues();
        simulation();
    }

    private void setInitialValues() {
        this.initalVaules = new InitialValues(5, 3);
        BuildingList buildingList = new BuildingList();
        buildingList.create();
        this.getInitialElevators(buildingList);
        this.getInitialFloors(buildingList);
        this.getInitialPeople(buildingList);
        this.buildingController = new BuildingController(buildingList);
    }

    private void getInitialElevators(BuildingList buildingList) {
        this.initalVaules.setElevatorCapacity(6);
        int amountElevators = this.initalVaules.getAmountElevators();

        for (int i = 0; i < amountElevators; i++) {
            int currentFloor = this.initalVaules.getElevatorFloor();
            int capacity = this.initalVaules.getElevatorCapacity();
            buildingList.get(0).addElevator(capacity, currentFloor);
        }
    }

    private void getInitialFloors(BuildingList buildingList) {
        int amountFloors = this.initalVaules.getAmountFloors();
        String label = this.initalVaules.getLabel();

        for (int i = 0; i <= amountFloors; i++) {
            buildingList.get(0).addFloor(label + i);
        }
    }

    private void getInitialPeople(BuildingList buildingList) {
        int amountPeople = this.initalVaules.getAmountPeople();

        for (int i = 0; i <= amountPeople; i++) {
            int timeOnFloor = this.initalVaules.getRandomTimeOnFloor(0, 8);
            int currentFloor = this.initalVaules.getElevatorFloor();
            int destination = this.initalVaules.getRandomFloor();
            buildingList.get(0).addPerson(timeOnFloor, currentFloor, destination);
        }
    }

    private void simulation() {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (!input.equals("q")) {
            ArrayList<Building> buildings = time.tick(buildingController);
            for (Building building : buildings) {
                render(building);
            }
            input = scanner.nextLine();
        }
        scanner.close();
    }

    private void render(Building building) {
        BuildingView buildingView = new BuildingView(building);
        String view = buildingView.render();
        System.out.println(view);
    }

}
