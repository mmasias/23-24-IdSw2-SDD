package Controllers;

import Models.Building;
import Views.BuildingView;

public class Simulation {

    public void start() {
        setInitialValues();
        Buildings.create(500);
        simulation();
    }

    private void setInitialValues() {
        InitialValues.setAmountFloors(6);
        InitialValues.setAmountElevators(3);
        InitialValues.setElevatorCapacity(7);
        InitialValues.setElevatorFloor(0);
        InitialValues.setLabel("Planta ");
    }

    private void simulation() {
        while (true) {
            for (Building building : Buildings.index()) {
                render(0);
            }
        }

    }

    private void render(int buildingId) {
        Building building = Buildings.get(buildingId);
        BuildingView buildingView = new BuildingView(building);
        String view = buildingView.render();
        System.out.println(view);
    }
}
