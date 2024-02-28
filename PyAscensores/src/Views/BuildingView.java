package Views;

import java.util.ArrayList;
import java.util.List;

import Models.Building;
import Models.Elevator;
import Models.Floor;

public class BuildingView {

    private List<Floor> Floors;
    private List<Elevator> Elevators;
    private ArrayList<String[]> Building;

    public BuildingView(Building building) {
        Floors = building.GetFloors();
        Elevators = building.GetElevators();
        Building = new ArrayList<String[]>();
    }

    public void render() {
        addElevatorToBuilding();
        addFloorToBuilding();
        for (int i = 0; i < Building.get(0).length; i++) {
            for (int j = 0; j < Building.size(); j++) {
                System.out.print(" " + Building.get(j)[i]);
            }
            System.out.println();
        }
    }

    private void addElevatorToBuilding() {
        for (Elevator elevator : Elevators) {
            String View = ElevatorView.render(elevator, Floors.size());
            String ViewSplit[] = View.split("\n");
            Building.add(ViewSplit);
        }
    }

    private void addFloorToBuilding() {
        addLeftWing();
        addRightWing();
        // TODO: Implement this method
    }

    private void addLeftWing() {
        // TODO: Implement this method
    }

    private void addRightWing() {
        // TODO: Implement this method
    }

}
