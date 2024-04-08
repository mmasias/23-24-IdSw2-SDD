package Models;

import java.util.Set;
import Enums.Direction;
import Controllers.Elevators;

public class ControlPanel {
    private int id;
    private Set<ElevatorRequest> elevatorRequests;
    private Set<FloorRequest> floorRequests;
    private Set<Integer> elevators;

    public ControlPanel(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void addElevatorRequest(ElevatorRequest elevatorRequest) {
        this.elevatorRequests.add(elevatorRequest);
    }

    public void removeElevatorRequest(ElevatorRequest elevatorRequest) {
        this.elevatorRequests.remove(elevatorRequest);
    }

    public void addFloorRequest(FloorRequest floorRequest) {
        this.floorRequests.add(floorRequest);
    }

    public void removeFloorRequest(FloorRequest floorRequest) {
        this.floorRequests.remove(floorRequest);
    }

    public boolean hasElevatorRequests() {
        return !this.elevatorRequests.isEmpty();
    }

    public boolean hasFloorRequests() {
        return !this.floorRequests.isEmpty();
    }

    public void setElevatorDirections() {
        Elevator elevator = Elevators.get(this.elevators.iterator().next());
        Direction direction = Direction.STOP;

        for (ElevatorRequest elevatorRequest : this.elevatorRequests) {
            if (elevatorRequest.getOrigin() > elevator.getCurrentFloor()) {
                direction = Direction.UP;
            } else if (elevatorRequest.getFloor() < elevator.getCurrentFloor()) {
                direction = Direction.DOWN;
            }
        }

        elevator.setDirection(direction);
    }
}
