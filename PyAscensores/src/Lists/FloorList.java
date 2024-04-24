package Lists;

import java.util.ArrayList;
import Models.Floor;

public class FloorList {
    private ArrayList<Floor> floors;
    private int counter;

    public FloorList() {
        this.floors = new ArrayList<Floor>();
        this.counter = 0;
    }

    public ArrayList<Floor> index() {
        return this.floors;
    }

    public Floor get(int id) {
        if (id >= 0 && id <= this.counter) {
            for (Floor floor : this.floors) {
                if (floor.getId() == id) {
                    return floor;
                }
            }
        }
        return null;
    }

    public void create(String label) {
        this.floors.add(new Floor(this.counter, label));
        this.counter++;
    }

    public void update(int id, Floor updatedFloor) {
        if (id >= 0 && id <= this.counter) {
            this.floors.set(id, updatedFloor);
        }
    }

    public void delete(int id) {
        if (id >= 0 && id <= this.counter) {
            this.floors.remove(id);
        }
    }
}
