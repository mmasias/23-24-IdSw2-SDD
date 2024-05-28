package Lists;

import java.util.ArrayList;

import Enums.Direction;

public class FloorsToGoList {
    private ArrayList<Integer> floorsToGo;

    public FloorsToGoList() {
        this.floorsToGo = new ArrayList<>();
    }

    public void add(int floor, Direction direction, int currentFloor) {
        if (this.floorsToGo.isEmpty()) {
            this.floorsToGo.add(floor);
        } else if (!this.floorsToGo.contains(floor)) {
            this.sortRequests(floor, direction, currentFloor);
        }

    }

    public void delete(int floor) {
        this.floorsToGo.remove(this.floorsToGo.indexOf(floor));
    }

    public int get(int index) {
        return this.floorsToGo.get(index);
    }

    public int size() {
        return this.floorsToGo.size();
    }

    public boolean isEmpty() {
        return this.floorsToGo.isEmpty();
    }

    public void clear() {
        this.floorsToGo.clear();
    }

    private void sortRequests(int floor, Direction direction, int currentFloor) {
        if (direction == Direction.UP) {
            for (int i = 0; i < this.floorsToGo.size(); i++) {
                if ((this.floorsToGo.get(i) > floor) && (currentFloor < floor)) {
                    this.floorsToGo.add(i, floor);
                    return;
                }
            }
            this.floorsToGo.add(floor);
        } else if (direction == Direction.DOWN) {
            for (int i = 0; i < this.floorsToGo.size(); i++) {
                if ((this.floorsToGo.get(i) < floor) && (currentFloor > floor)) {
                    this.floorsToGo.add(i, floor);
                    return;
                }
            }
            this.floorsToGo.add(floor);
        }
    }
}
