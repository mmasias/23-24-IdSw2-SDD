package Models;

import Enums.Direction;

public class ElevatorRequest {
    private Direction ElevatorDirection;
    private int Origen;

    public ElevatorRequest(int Origen, Direction ElevatorDirection) {
        this.Origen = Origen;
        this.ElevatorDirection = ElevatorDirection;
    }

    public Direction getElevatorDirection() {
        return ElevatorDirection;
    }

    public void setElevatorDirection(Direction ElevatorDirection) {
        this.ElevatorDirection = ElevatorDirection;
    }

    public int getOrigen() {
        return Origen;
    }

    public void setOrigen(int Origen) {
        this.Origen = Origen;
    }
}
