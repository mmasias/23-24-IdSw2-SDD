package Controllers;

import java.util.ArrayList;

import Lists.BuildingList;
import Models.Building;

public class BuildingController {

    private BuildingList buildings;

    public BuildingController(BuildingList buildingList) {
        this.buildings = buildingList;
    }

    public ArrayList<Building> update() {
        for (Building building : this.buildings.index()) {
            // TODO: Implement update method
        }
        return this.buildings.index();
    }
}
