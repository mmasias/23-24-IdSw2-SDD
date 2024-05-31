package src.Views;

import java.util.ArrayList;
import src.Models.*;

public class BuildingView {
    private Building building;
    private boolean isTesting;

    public BuildingView(Building building, boolean isTesting) {
        this.building = building;
        this.isTesting = isTesting;
    }

    public void render() {
        ArrayList<String[]> views = this.getViews(building);
        String mergedViews = this.mergeViews(views, building);
        System.out.println(mergedViews);

        DebuggerView debugger = new DebuggerView(building, this.isTesting);
        debugger.render();
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

        mergedViews.append(this.spacesBeforeAndAfter(9, 20, "Personas"));
        mergedViews.append(this.spacesBeforeAndAfter(0, 0, "Personas\n"));
        mergedViews.append(this.spacesBeforeAndAfter(9, 20, "Esperando"));
        mergedViews.append(this.spacesBeforeAndAfter(0, 0, "en Planta\n"));

        for (int i = 0; i < building.getFloors().size(); i++) {
            for (String[] view : views) {
                mergedViews.append(view[i] + "  ");
            }
            mergedViews.append("\n");
        }

        mergedViews.append(this.spacesBeforeAndAfter(15, 0, "/---- Ascensores ----/\n"));

        return mergedViews.toString();
    }

    private String spacesBeforeAndAfter(int SpacesBefore, int SpacesAfter, String text) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < SpacesBefore; i++) {
            builder.append(" ");
        }

        builder.append(text);

        for (int i = 0; i < SpacesAfter; i++) {
            builder.append(" ");
        }

        return builder.toString();
    }
}
