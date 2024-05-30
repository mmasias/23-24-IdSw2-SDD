package Models;

import java.util.List;

import Lists.ElevatorRequestList;
import Lists.FloorRequestList;

public class ControlPanel {
    private ElevatorRequestList elevatorRequests;
    private FloorRequestList floorRequests;

    public ControlPanel() {
        elevatorRequests = new ElevatorRequestList();
        floorRequests = new FloorRequestList();
    }

    public List<ElevatorRequest> getElevatorRequests() {
        return this.elevatorRequests.index();
    }

    public void addElevatorRequest(ElevatorRequest elevatorRequest) {
        this.elevatorRequests.add(elevatorRequest);
    }

    public void removeElevatorRequest(ElevatorRequest elevatorRequest) {
        this.elevatorRequests.remove(elevatorRequest);
    }

    public List<FloorRequest> getFloorRequests() {
        return this.floorRequests.index();
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
}
