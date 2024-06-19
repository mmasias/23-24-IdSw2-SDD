package src.Controllers;

import src.Models.*;
import src.Views.BuildingView;
import java.util.Scanner;

public class Simulation {
    private BuildingController buildingController;
    private Values initialValues;
    private Time time;
    private Building building;

    public Simulation(Values values) {
        this.initialValues = values;
    }

    public void start(boolean isTesting) {
        this.time = new Time();
        Creation creation = new Creation(initialValues);
        this.building = creation.createBuilding();
        this.buildingController = creation.createBuildingController(this.building);

        this.simulation(isTesting);
    }

    private void simulation(boolean isTesting) {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        new BuildingView(this.building, isTesting).render();
        input = scanner.nextLine();

        while (!input.equals("q")) {
            Building building = time.tickFloors(buildingController);
            new BuildingView(building, isTesting).render();

            building = time.tickElevators(buildingController);
            new BuildingView(building, isTesting).render();

            building = time.tickControlPanels(buildingController);
            new BuildingView(building, isTesting).render();
            input = scanner.nextLine();
        }
        scanner.close();
    }
}
