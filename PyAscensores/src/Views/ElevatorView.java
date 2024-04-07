package Views;

import java.util.ArrayList;
import java.util.List;

import Models.Elevator;

public class ElevatorView {
    private char[] directionIcons = { '↑', '↓', '-' };
    private List<Elevator> elevators;
    private int totalFloors;

    public ElevatorView(List<Elevator> elevators, int totalFloors) {
        this.elevators = elevators;
        this.totalFloors = totalFloors;
    }

    public String[] render() {
        ArrayList<String[]> renderedElevators = new ArrayList<String[]>();
        for (Elevator elevator : elevators) {
            String view[] = getElevatorView(elevator).split("\n");
            renderedElevators.add(view);
        }

        String[] view = mergeElevatorsViews(renderedElevators);
        return view;
    }

    private String getElevatorView(Elevator elevator) {
        StringBuilder elevatorView = new StringBuilder();
        int currentFloor = elevator.getCurrentFloor();
        char direction = directionIcons[elevator.getDirection().ordinal()];

        for (int i = totalFloors - 1; i >= 0; i--) {
            if (i == currentFloor) {
                int peopleInside = elevator.getPeopleInside();
                String elevatorStr = "[" + direction + peopleInside + direction + "]";
                elevatorView.append(elevatorStr);
            } else {
                elevatorView.append(" | | ");
            }
            elevatorView.append("\n");
        }

        return elevatorView.toString();
    }

    private String[] mergeElevatorsViews(ArrayList<String[]> views) {
        StringBuilder mergedView = new StringBuilder();
        
        for (int i = 0; i < totalFloors; i++) {
            for (String[] view : views) {
                mergedView.append(view[i]);
            }
            mergedView.append("\n");
        }

        return mergedView.toString().split("\n");
    }
}
