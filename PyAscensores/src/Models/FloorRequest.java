package Models;

public class FloorRequest {
    private int destination;
    private int elevatorId;

    public FloorRequest(int destination, int elevatorId) {
        this.destination = destination;
        this.elevatorId = elevatorId;
    }

    public int getDestination() {
        return this.destination;
    }

    public int getElevatorId() {
        return this.elevatorId;
    }
}
