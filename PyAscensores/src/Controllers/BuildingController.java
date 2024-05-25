package Controllers;

import java.util.ArrayList;

import Lists.BuildingList;
import Models.Building;

public class BuildingController {
    private BuildingList buildings;
    private ElevatorController elevatorController;
    private FloorController floorController;
    private ControlPanelController controlPanelController;

    public BuildingController(BuildingList buildingList) {
        this.buildings = buildingList;
        this.elevatorController = new ElevatorController();
        this.floorController = new FloorController();
        this.controlPanelController = new ControlPanelController();
    }

    public ArrayList<Building> index() {
        return this.buildings.index();
    }

    public ArrayList<Building> update() {
        for (Building building : this.buildings.index()) {
            floorController.update(building);
            elevatorController.update(building);
            controlPanelController.update(building);
        }
        return this.buildings.index();
    }

    public ArrayList<Building> updateFloors() {
        for (Building building : this.buildings.index()) {
            building = floorController.update(building);
        }
        return this.buildings.index();
    }

    public ArrayList<Building> updateElevators() {
        for (Building building : this.buildings.index()) {
            building = elevatorController.update(building);
        }
        return this.buildings.index();
    }

    public ArrayList<Building> updateControlPanels() {
        for (Building building : this.buildings.index()) {
            building = controlPanelController.update(building);
        }
        return this.buildings.index();
    }
}
