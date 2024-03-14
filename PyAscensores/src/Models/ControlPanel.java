package Models;

import java.util.List;

public class ControlPanel implements IModel {
    private List<Integer> floorsToStop;
    private List<Integer> floorsToGo;

    public ControlPanel(List<Integer> floorsToStop, List<Integer> floorsToGo) {
        this.floorsToStop = floorsToStop;
        this.floorsToGo = floorsToGo;
    }

    public List<Integer> getfloorsToStop() {
        return floorsToStop;
    }

    public List<Integer> getfloorsToGo() {
        return floorsToGo;
    }

    public void addFloorToStop(int floor) {
        this.floorsToStop.add(floor);
    }

    public void addFloorToGo(int floor) {
        this.floorsToGo.add(floor);
    }

    public void removeFloorToStop(int floor) {
        this.floorsToStop.remove(floor);
    }

    public void removeFloorToGo(int floor) {
        this.floorsToGo.remove(floor);
    }

    public void clearFloorsToStop() {
        this.floorsToStop.clear();
    }

    public void clearFloorsToGo() {
        this.floorsToGo.clear();
    }

    public boolean hasFloorsToStop() {
        return !this.floorsToStop.isEmpty();
    }

    public boolean hasFloorsToGo() {
        return !this.floorsToGo.isEmpty();
    }
}
