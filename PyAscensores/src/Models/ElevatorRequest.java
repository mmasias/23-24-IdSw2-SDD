package Models;

import Enums.Direction;

public class ElevatorRequest {
    private Direction direction;
    private int origin;
    private boolean isLinkedToElevator = false;

    public ElevatorRequest(int Origin, Direction Direction) {
        this.origin = Origin;
        this.direction = Direction;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public int getOrigin() {
        return this.origin;
    }

    public boolean isLinkedToElevator() {
        return this.isLinkedToElevator;
    }
    public void setLinkedToElevator(boolean isLinkedToElevator) {
        this.isLinkedToElevator = isLinkedToElevator;
    }
}
