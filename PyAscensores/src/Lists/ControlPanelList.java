package Lists;

import java.util.ArrayList;
import Models.ControlPanel;

public class ControlPanelList {
    private ArrayList<ControlPanel> controlPanels;
    private int counter;

    public ControlPanelList() {
        this.controlPanels = new ArrayList<ControlPanel>();
        this.counter = 0;
    }

    public ArrayList<ControlPanel> index() {
        return this.controlPanels;
    }

    public ControlPanel get(int id) {
        if (id >= 0 && id <= this.controlPanels.size()) {
            for (ControlPanel controlPanel : this.controlPanels) {
                if (controlPanel.getId() == id) {
                    return controlPanel;
                }
            }
        }
        return null;
    }

    public void create() {
        this.controlPanels.add(new ControlPanel(this.counter));
        this.counter++;
    }

    public void update(int id, ControlPanel updatedControlPanel) {
        if (id >= 0 && id <= this.counter) {
            this.controlPanels.set(id, updatedControlPanel);
        }
    }

    public void delete(int id) {
        if (id >= 0 && id <= this.counter) {
            this.controlPanels.remove(id);
        }
    }
}
