package Lists;

import java.util.ArrayList;
import Models.ControlPanel;

public class ControlPanelList {
    private ModelList<ControlPanel> controlPanels;

    public ControlPanelList() {
        this.controlPanels = new ModelList<ControlPanel>();
    }

    public ArrayList<ControlPanel> index() {
        return this.controlPanels.index();
    }

    public ControlPanel get(int id) {
        return this.controlPanels.get(id);
    }

    public void create(int id) {
        this.controlPanels.add(new ControlPanel(id));
    }

    public void update(int id, ControlPanel updatedControlPanel) {
        this.controlPanels.update(id, updatedControlPanel);
    }

    public void delete(int id) {
        this.controlPanels.delete(id);
    }

    public void add(ControlPanel controlPanel) {
        this.controlPanels.add(controlPanel);
    }
}
