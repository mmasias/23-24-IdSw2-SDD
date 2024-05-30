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
        Creation creation = new Creation(initialValues);
        this.building = creation.createBuilding();
        this.buildingController = creation.createBuildingController(this.building);

        this.simulation(isTesting);
    }

    private void simulation(boolean isTesting) {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        new BuildingView(building, isTesting).render();
        input = scanner.nextLine();

        while (!input.equals("q")) {
            Building building = time.tickFloors(buildingController);
            new BuildingView(building, isTesting).render();
            input = scanner.nextLine();

            building = time.tickElevators(buildingController);
            new BuildingView(building, isTesting).render();
            input = scanner.nextLine();

            building = time.tickControlPanels(buildingController);
            new BuildingView(building, isTesting).render();
            input = scanner.nextLine();
        }
        scanner.close();
    }
}
