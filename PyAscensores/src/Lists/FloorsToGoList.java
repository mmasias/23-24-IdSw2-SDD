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
        } else if (!this.floorsToGo.contains(floor)) {
            this.sortRequests(floor, direction);
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
    private String printList(ArrayList<Integer> floorsToGoList) {
        String list = "";
        for (int i = 0; i < floorsToGoList.size(); i++) {
            list += floorsToGoList.get(i) + ", ";
        }
        return list;
    }
    private void sortRequests(int floor, Direction direction) {
        System.out.println("1Sort request: " + floor + " " + direction + " " + printList(this.floorsToGo) + "");
        if (direction == Direction.UP) {
            for (int i = 0; i < this.floorsToGo.size(); i++) {
                if (this.floorsToGo.get(i) > floor) {
                    this.floorsToGo.add(i, floor);
                    System.out.println("2Sort request: " + floor + " " + direction + " " + printList(this.floorsToGo) + "");
                    return;
                }
            }
            this.floorsToGo.add(floor);
            System.out.println("2fSort request: " + floor + " " + direction + " " + printList(this.floorsToGo) + "");
        } else if (direction == Direction.DOWN) {
            for (int i = 0; i < this.floorsToGo.size(); i++) {
                if (this.floorsToGo.get(i) < floor) {
                    this.floorsToGo.add(i, floor);
                    System.out.println("3Sort request: " + floor + " " + direction + " " + printList(this.floorsToGo) + "");
                    return;
                }
            }
            this.floorsToGo.add(floor);
            System.out.println("3fSort request: " + floor + " " + direction + " " + printList(this.floorsToGo) + "");

        }
    }
}
