package Views;

import Models.Elevator;

public class ElevatorView {
    private static char[] directionIcons = { '↑', '↓', '-' };

    public static String render(Elevator elevator, int totalFloors) {
        StringBuilder elevatorView = new StringBuilder();
        int currentFloor = elevator.getCurrentFloor();
        char direction = directionIcons[elevator.getDirection().ordinal()];

        for (int i = totalFloors; i >= 0; i--) {
            if (i == currentFloor) {
                int capacity = elevator.getCapacity();
                String elevatorStr = "[" + direction + capacity + direction + "]";
                elevatorView.append(elevatorStr);
            } else {
                elevatorView.append(" | | ");
            }
            elevatorView.append("\n");
        }

        return elevatorView.toString();
    }
}
