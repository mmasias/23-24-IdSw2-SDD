package Controllers;

import java.util.ArrayList;
import Models.Building;

public class Buildings {

    private static ArrayList<Building> buildings = new ArrayList<Building>();

    public static ArrayList<Building> index() {
        return buildings;
    }

    public static Building get(int id) {
        if (id >= 0 && id < buildings.size()) {
            return buildings.get(id);
        }
        return null;
    }

    public static void create(int capacity) {
        buildings.add(new Building(buildings.size(), capacity));
    }

    public static void update(int id, Building updatedBuilding) {
        if (id >= 0 && id < buildings.size()) {
            buildings.set(id, updatedBuilding);
        }
    }

    public static void delete(int id) {
        if (id >= 0 && id < buildings.size()) {
            buildings.remove(id);
        }
    }

}
