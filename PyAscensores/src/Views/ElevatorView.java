package Views;

import Models.Elevator;

public class ElevatorView {
    private static char[] directionIcons = {'↑', '↓', '-'};

    public static String render(Elevator elevator) {
        StringBuilder sb = new StringBuilder();
        int totalFloors = 10;
        int currentFloor = elevator.getCurrentFloor();
        char direction = directionIcons[elevator.getDirection().ordinal()];

        for (int i = totalFloors; i >= 0; i--) {
            if (i == currentFloor) {
                sb.append("[" + direction + elevator.getCapacity() + direction + "]");
            } else {
                sb.append(" | | ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
