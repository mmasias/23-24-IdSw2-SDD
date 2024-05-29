package Controllers;

import Models.Building;

public class BuildingController {
    private Building building;
    private ElevatorController elevatorController;
    private FloorController floorController;
    private ControlPanelController controlPanelController;

    public BuildingController(Building building) {
        this.building = building;
        this.elevatorController = new ElevatorController();
        this.floorController = new FloorController();
        this.controlPanelController = new ControlPanelController();
    }

    public Building index() {
        return this.building;
    }

    public Building update() {
        floorController.update(building);
        elevatorController.update(building);
        controlPanelController.update(building);
        return this.building;
    }

    public Building updateFloors() {
        return floorController.update(building);
    }

    public Building updateElevators() {
        return elevatorController.update(building);
    }

    public Building updateControlPanels() {
        return controlPanelController.update(building);
    }
}
