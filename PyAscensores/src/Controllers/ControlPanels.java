package Controllers;

import java.util.ArrayList;
import java.util.Set;

import Models.ControlPanel;

class ControlPanels {

    private static ArrayList<ControlPanel> controlPanels = new ArrayList<ControlPanel>();

    public static ArrayList<ControlPanel> index() {
        return controlPanels;
    }

    public static ControlPanel get(int id) {
        if (id >= 0 && id < controlPanels.size()) {
            return controlPanels.get(id);
        }
        return null;
    }

    public static void create(Set<Integer> floorsToStop, Set<Integer> floorsToGo) {
        ControlPanel controlPanel = new ControlPanel(controlPanels.size());
        controlPanels.add(controlPanel);
    }

    public static void update(int id, ControlPanel updatedControlPanel) {
        if (id >= 0 && id < controlPanels.size()) {
            controlPanels.set(id, updatedControlPanel);
        }
    }

    public static void delete(int id) {
        if (id >= 0 && id < controlPanels.size()) {
            controlPanels.remove(id);
        }
    }
}