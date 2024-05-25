package Lists;

import java.util.ArrayList;

import Enums.Direction;

public class FloorsToGoList {
    private ArrayList<Integer> floorsToGo;

    public FloorsToGoList() {
        this.floorsToGo = new ArrayList<Integer>();
    }

    public void add(int floor, Direction direction) {
        if (this.floorsToGo.isEmpty()) {
            this.floorsToGo.add(floor);
            return;
        }else if (!this.floorsToGo.contains(floor)) {
            if (direction == Direction.UP) {
                for (int i = 0; i < this.floorsToGo.size(); i++) {
                    if (this.floorsToGo.get(i) > floor) {
                        this.floorsToGo.add(i, floor);
                        return;
                    }
                }
                this.floorsToGo.add(floor);
            } else {
                for (int i = 0; i < this.floorsToGo.size(); i++) {
                    if (this.floorsToGo.get(i) < floor) {
                        this.floorsToGo.add(i, floor);
                        return;
                    }
                }
                this.floorsToGo.add(floor);
            }
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
    
}
