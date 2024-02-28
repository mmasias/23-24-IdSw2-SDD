package Models;

import Enums.Direction;

public class ElevatorRequest {
    private Direction Direction;
    private int Origin;

    public ElevatorRequest(int Origin, Direction Direction) {
        this.Origin = Origin;
        this.Direction = Direction;
    }

    public Direction getDirection() {
        return Direction;
    }

    public void setDirection(Direction Direction) {
        this.Direction = Direction;
    }

    public int getOrigin() {
        return Origin;
    }

    public void setOrigen(int Origen) {
        this.Origin = Origen;
    }
}
