package Lists;

import java.util.ArrayList;
import Models.Floor;

public class FloorList {
    private ModelList<Floor> floors;

    public FloorList() {
        this.floors = new ModelList<Floor>();
    }

    public ArrayList<Floor> index() {
        return this.floors.index();
    }

    public Floor get(int id) {
        return this.floors.get(id);
    }

    public void create(int id, String label) {
        this.floors.add(new Floor(id, label));
    }

    public void update(int id, Floor updatedFloor) {
        this.floors.update(id, updatedFloor);
    }

    public void delete(int id) {
        this.floors.delete(id);
    }

    public void add(Floor floor) {
        this.floors.add(floor);
    }
}
