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
        for (Elevator e : Elevators) {
            String eView = ElevatorView.render(e, Floors.size());
            String eViewSplit[] = eView.split("\n");
            Building.add(eViewSplit);
        }

        for (int i = 0; i < Building.get(0).length; i++) {
            for (int j = 0; j < Building.size(); j++) {
                System.out.print(" " + Building.get(j)[i]);
            }
            System.out.println();
        }
    }

}
