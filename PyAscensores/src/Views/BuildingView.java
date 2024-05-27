package Views;

import java.util.ArrayList;
import Models.Building;
import Models.Elevator;
import Models.Floor;

public class BuildingView {
    private ArrayList<Building> buildings;
    boolean isTesting;

    public BuildingView(ArrayList<Building> buildings, boolean isTesting) {
        this.buildings = buildings;
        this.isTesting = isTesting;
    }

    public void render() {
        for (Building building : buildings) {
            ArrayList<String[]> views = this.getViews(building);
            String mergedViews = this.mergeViews(views, building);
            System.out.println(mergedViews);

            DebuggerView debugger = new DebuggerView(building, this.isTesting);
            debugger.render();
        }
    }

    private ArrayList<String[]> getViews(Building building) {
        ArrayList<String[]> views = new ArrayList<String[]>();

        ArrayList<Elevator> elevators = building.getElevators();
        ArrayList<Floor> floors = building.getFloors();

        ElevatorView elevator = new ElevatorView(elevators, floors.size());
        FloorView floor = new FloorView(floors);
        PeopleOnFloorView peopleOnFloor = new PeopleOnFloorView(floors);
        WaitingPeopleView peopleWaiting = new WaitingPeopleView(floors);

        views.add(floor.render());
        views.add(peopleWaiting.render());
        views.add(elevator.render());
        views.add(peopleOnFloor.render());

        return views;
    }

    private String mergeViews(ArrayList<String[]> views, Building building) {
        StringBuilder mergedViews = new StringBuilder();
        for (int i = 0; i < building.getFloors().size(); i++) {
            for (String[] view : views) {
                mergedViews.append(view[i] + "  ");
            }
            mergedViews.append("\n");
        }

        return mergedViews.toString();
    }
}
