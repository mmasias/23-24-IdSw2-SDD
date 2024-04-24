package Lists;

import java.util.ArrayList;
import Models.Building;

public class BuildingList {
    private ArrayList<Building> buildings;
    private int counter;

    public BuildingList() {
        this.buildings = new ArrayList<Building>();
        this.counter = 0;
    }

    public Building get(int id) {
        if (id >= 0 && id <= this.counter) {
            for (Building building : this.buildings) {
                if (building.getId() == id) {
                    return building;
                }
            }
        }
        return null;
    }

    public ArrayList<Building> index() {
        return this.buildings;
    }

    public void create() {
        this.buildings.add(new Building(this.counter));
        this.counter++;
    }

    public void update(int id, Building updatedBuilding) {
        if (id >= 0 && id <= this.counter) {
            this.buildings.set(id, updatedBuilding);
        }
    }

    public void delete(int id) {
        if (id >= 0 && id < this.counter) {
            this.buildings.remove(id);
        }
    }
}
