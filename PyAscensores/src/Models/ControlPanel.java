package Models;

import java.util.Set;

public class ControlPanel implements IModel {
    private int id;
    private Set<Integer> floorsToStopList;
    private Set<Integer> floorsToGoList;

    public ControlPanel(int id, Set<Integer> floorsToStop, Set<Integer> floorsToGo) {
        this.id = id;
        this.floorsToStopList = floorsToStop;
        this.floorsToGoList = floorsToGo;
    }
    
    public int getId() {
        return id;
    }

    public Set<Integer> getfloorsToStop() {
        return floorsToStopList;
    }

    public Set<Integer> getfloorsToGo() {
        return floorsToGoList;
    }
    public void setFloorsToStopList(Set<Integer> floorsToStop) {
        this.floorsToStopList = floorsToStop;
    }
    public void setFloorsToGoList(Set<Integer> floorsToGo) {
        this.floorsToGoList = floorsToGo;
    }
    public Set<Integer> getFloorsToStopList() {
        return floorsToStopList;
    }
    public Set<Integer> getFloorsToGoList() {
        return floorsToGoList;
    }

    public void addFloorToStop(int floor) {
        this.floorsToStopList.add(floor);
    }

    public void addFloorToGo(int floor) {
        this.floorsToGoList.add(floor);
    }

    public void removeFloorToStop(int floor) {
        this.floorsToStopList.remove(floor);
    }

    public void removeFloorToGo(int floor) {
        this.floorsToGoList.remove(floor);
    }

    public void clearFloorsToStop() {
        this.floorsToStopList.clear();
    }

    public void clearFloorsToGo() {
        this.floorsToGoList.clear();
    }

    public boolean hasFloorsToStop() {
        return !this.floorsToStopList.isEmpty();
    }

    public boolean hasFloorsToGo() {
        return !this.floorsToGoList.isEmpty();
    }
}
