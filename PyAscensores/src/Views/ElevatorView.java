package Views;

import Models.Elevator;

public class ElevatorView {
    public static String render(Elevator elevator) {
        StringBuilder sb = new StringBuilder();
        int totalFloors = 10;
        int currentFloor = elevator.getCurrentFloor();
        char direction;
        switch (elevator.getDirection()) {
            case UP:
                direction = '↑';
                break;
            case DOWN:
                direction = '↓';
                break;
            default:
                direction = '-';
                break;
        }

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
