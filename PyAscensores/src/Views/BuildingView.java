package Views;

import java.util.ArrayList;
import java.util.List;
import Models.Building;
import Models.Elevator;
import Models.Floor;

public class BuildingView {
    private ArrayList<String[]> Building;
    private ElevatorView ElevatorView;
    private FloorView FloorView;
    private PeopleOnFloorView PeopleOnFloorView;
    private WaitingPeopleView PeopleWaitingView;

    public BuildingView(Building building) {
        List<Elevator> Elevators = building.getElevators();
        List<Floor> Floors = building.getFloors();

        Building = new ArrayList<String[]>();
        ElevatorView = new ElevatorView(Elevators, Floors.size());
        FloorView = new FloorView(Floors);
        PeopleOnFloorView = new PeopleOnFloorView(Floors);
        PeopleWaitingView = new WaitingPeopleView(Floors);
    }

    public void render() {
        Building = FloorView.render(Building);
        Building = PeopleOnFloorView.render(Building);
        Building = ElevatorView.render(Building);
        Building = PeopleWaitingView.render(Building);

        printBuilding();
    }

    private void printBuilding() {
        for (int i = 0; i < Building.get(0).length; i++) {
            for (int j = 0; j < Building.size(); j++) {
                System.out.print(" " + Building.get(j)[i]);
            }
            System.out.println();
        }
    }

}
