package Controllers;

import java.util.ArrayList;

import Lists.BuildingList;
import Models.Building;

public class BuildingController {

    private BuildingList buildings;
    private ElevatorController elevatorController;

    public BuildingController(BuildingList buildingList) {
        this.buildings = buildingList;
        this.elevatorController = new ElevatorController();
    }

    public ArrayList<Building> update() {
        for (Building building : this.buildings.index()) {
            // TODO: Implement update method
            // elevatorController.update(building);
        }
        return this.buildings.index();
    }
}
