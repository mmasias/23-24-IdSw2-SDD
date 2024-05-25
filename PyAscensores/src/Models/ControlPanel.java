package Models;

import java.util.HashSet;
import java.util.Set;

public class ControlPanel implements IModel {
    private int id;
    private Set<ElevatorRequest> elevatorRequests;
    private Set<FloorRequest> floorRequests;
    private Set<Integer> elevators;

    public ControlPanel(int id) {
        this.id = id;
        elevatorRequests = new HashSet<ElevatorRequest>();
        floorRequests = new HashSet<FloorRequest>();
        elevators = new HashSet<Integer>();
    }

    public int getId() {
        return this.id;
    }

    public Set<ElevatorRequest> getElevatorRequests() {
        return this.elevatorRequests;
    }

    public void addElevatorRequest(ElevatorRequest elevatorRequest) {
        this.elevatorRequests.add(elevatorRequest);
    }

    public void removeElevatorRequest(ElevatorRequest elevatorRequest) {
        this.elevatorRequests.remove(elevatorRequest);
    }

    public Set<FloorRequest> getFloorRequests() {
        return this.floorRequests;
    }

    public void addFloorRequest(FloorRequest floorRequest) {
        this.floorRequests.add(floorRequest);
    }

    public void removeFloorRequest(FloorRequest floorRequest) {
        this.floorRequests.remove(floorRequest);
    }

    public Set<Integer> getElevators() {
        return this.elevators;
    }

    public void addElevator(int elevator) {
        this.elevators.add(elevator);
    }

    public void removeElevator(int elevator) {
        this.elevators.remove(elevator);
    }

    public boolean hasElevatorRequests() {
        return !this.elevatorRequests.isEmpty();
    }

    public boolean hasFloorRequests() {
        return !this.floorRequests.isEmpty();
    }
}
