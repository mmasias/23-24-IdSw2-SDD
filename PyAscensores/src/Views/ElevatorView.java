package Views;

import java.util.ArrayList;
import java.util.List;
import Models.Elevator;

public class ElevatorView {
    private char[] directionIcons = { '↑', '↓', '-' };
    private List<Elevator> Elevators;
    private int TotalFloors;

    public ElevatorView(List<Elevator> elevators, int totalFloors) {
        Elevators = elevators;
        TotalFloors = totalFloors;
    }

    public ArrayList<String[]> render(ArrayList<String[]> building) {
        for (Elevator elevator : Elevators) {
            String View = getElevatorView(elevator, TotalFloors);
            String ViewSplit[] = View.split("\n");
            building.add(ViewSplit);
        }

        return building;
    }

    private String getElevatorView(Elevator elevator, int totalFloors) {
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
}
