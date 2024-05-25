package Controllers;

import Models.Building;
import java.util.ArrayList;

public class Time {
    public ArrayList<Building> tick(BuildingController controller) {
        return controller.update();
    }

    public ArrayList<Building> tickFloors(BuildingController controller) {
        return controller.updateFloors();
    }

    public ArrayList<Building> tickElevators(BuildingController controller) {
        return controller.updateElevators();
    }

    public ArrayList<Building> tickControlPanels(BuildingController controller) {
        return controller.updateControlPanels();
    }
}
