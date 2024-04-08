package Controllers;

import java.util.ArrayList;

import Models.Floor;

public class Floors {

    private static ArrayList<Floor> floors = new ArrayList<Floor>();

    public static void create(String label) {
        floors.add(new Floor(floors.size(), label));
    }

    public static Floor get(int id) {
        if (id >= 0 && id < floors.size()) {
            return floors.get(id);
        }
        return null;
    }

    public static ArrayList<Floor> index() {
        return floors;
    }

    public static void update(int id, Floor updatedFloor) {
        if (id >= 0 && id < floors.size()) {
            floors.set(id, updatedFloor);
        }
    }

    public static void delete(int id) {
        if (id >= 0 && id < floors.size()) {
            floors.remove(id);
        }
    }

}
