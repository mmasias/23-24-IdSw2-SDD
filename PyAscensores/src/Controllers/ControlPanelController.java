package Controllers;

import java.util.ArrayList;
import java.util.Set;

import Models.ControlPanel;

class ControlPanelController {

    private static ArrayList<ControlPanel> ControlPanels = new ArrayList<ControlPanel>();

    public static ArrayList<ControlPanel> index() {
        return ControlPanels;
    }
    public static ControlPanel get(int id) {
        return ControlPanels.get(id);
    }
    public static void create(int id, Set<Integer> floorsToStop, Set<Integer> floorsToGo) {
        ControlPanel controlPanel = new ControlPanel(id, floorsToStop, floorsToGo);
        ControlPanels.add(controlPanel);
    }
    public static void update(int id, Set<Integer> floorsToStop, Set<Integer> floorsToGo) {
        ControlPanel controlPanel = ControlPanels.get(id);
        controlPanel.setFloorsToStopList(floorsToStop);
        controlPanel.setFloorsToGoList(floorsToGo);
    }
}