package Views;

import java.util.ArrayList;
import java.util.List;
import Models.Building;
import Models.Elevator;
import Models.Floor;

public class BuildingView {
    private ElevatorView elevatorView;
    private FloorView floorView;
    private PeopleOnFloorView peopleOnFloorView;
    private WaitingPeopleView peopleWaitingView;

    private ArrayList<String[]> renderedView;

    public BuildingView(Building building) {
        List<Elevator> elevators = building.getElevators();
        List<Floor> floors = building.getFloors();

        elevatorView = new ElevatorView(elevators, floors.size());
        floorView = new FloorView(floors);
        peopleOnFloorView = new PeopleOnFloorView(floors);
        peopleWaitingView = new WaitingPeopleView(floors);

        renderedView = new ArrayList<String[]>();
    }

    public String render() {
        ArrayList<String[]> views = new ArrayList<String[]>();

        views.add(floorView.render());
        views.add(peopleOnFloorView.render());
        views.add(elevatorView.render());
        views.add(peopleWaitingView.render());

        // We need to return all the views in a single string
        StringBuilder mergedView = new StringBuilder();
        for (String[] view : views) {
            for (String line : view) {
                mergedView.append(line);
                mergedView.append("\n");
            }
        }

        return mergedView.toString();
    }

}
