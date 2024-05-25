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
            controlPanelController.update(building);
            elevatorController.update(building);
            floorController.update(building);
        }
        return this.buildings.index();
    }
}
