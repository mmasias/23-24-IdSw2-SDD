package Views;

import java.util.ArrayList;
import java.util.List;
import Models.Building;
import Models.Elevator;
import Models.Floor;
import Controllers.Elevators;

public class BuildingView {
    private Building building;
    private ElevatorView elevatorView;
    private FloorView floorView;
    private PeopleOnFloorView peopleOnFloorView;
    private WaitingPeopleView peopleWaitingView;

    public BuildingView(Building building) {
        this.building = building;
        ArrayList<Elevator> elevators = buildings.getElevators();
        ArrayList<Floor> floors = buildings.getFloors();

        elevatorView = new ElevatorView(elevators, floors.size());
        floorView = new FloorView(floors);
        peopleOnFloorView = new PeopleOnFloorView(floors);
        peopleWaitingView = new WaitingPeopleView(floors);
    }

    public String render() {
        ArrayList<String[]> views = new ArrayList<String[]>();

        views.add(floorView.render());
        views.add(peopleOnFloorView.render());
        views.add(elevatorView.render());
        views.add(peopleWaitingView.render());

        StringBuilder mergedView = new StringBuilder();

        for (int i = 0; i < building.getFloors().size(); i++) {
            for (String[] view : views) {
                mergedView.append(view[i] + "  ");
            }
            mergedView.append("\n");
        }

        return mergedView.toString();
    }

}
