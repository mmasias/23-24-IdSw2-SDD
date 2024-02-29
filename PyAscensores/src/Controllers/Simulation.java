package Controllers;

import Models.Building;
import Views.BuildingView;

public class Simulation {

    public void start() {
        setInitialValues();
        Buildings.createBuilding();
        render();
    }

    private void setInitialValues() {
        InitialValues.setAmountFloors(6);
        InitialValues.setAmountElevators(3);
        InitialValues.setElevatorCapacity(7);
        InitialValues.setElevatorFloor(0);
        InitialValues.setLabel("Planta ");
    }

    private void render() {
        Building building = Buildings.getBuilding();
        BuildingView buildingView = new BuildingView(building);
        buildingView.render();
    }
}
