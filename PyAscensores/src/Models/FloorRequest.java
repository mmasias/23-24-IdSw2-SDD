package Models;

import Enums.Direction;

public class FloorRequest {
    private Direction direction;
    private int destination;

    public FloorRequest(int destination, Direction direction) {
        this.destination = destination;
        this.direction = direction;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public int getDestination() {
        return this.destination;
    }
}
