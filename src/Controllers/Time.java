package src.Controllers;

import src.Models.Building;

public class Time {
    public Building tick(BuildingController controller) {
        return controller.update();
    }

    public Building tickFloors(BuildingController controller) {
        return controller.updateFloors();
    }

    public Building tickElevators(BuildingController controller) {
        return controller.updateElevators();
    }

    public Building tickControlPanels(BuildingController controller) {
        return controller.updateControlPanels();
    }
}
