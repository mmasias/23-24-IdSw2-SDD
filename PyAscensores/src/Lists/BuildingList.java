package Lists;

import java.util.ArrayList;
import Models.Building;

public class BuildingList {

    private ModelList<Building> buildings;

    public BuildingList() {
        this.buildings = new ModelList<Building>();
    }

    public Building get(int id) {
        return this.buildings.get(id);
    }

    public ArrayList<Building> index() {
        return this.buildings.index();
    }

    public void create(int id) {
        this.buildings.add(new Building(id));
    }

    public void update(int id, Building updatedBuilding) {
        this.buildings.update(id, updatedBuilding);
    }

    public void delete(int id) {
        this.buildings.delete(id);
    }

    public void add(Building building) {
        this.buildings.add(building);
    }
}
