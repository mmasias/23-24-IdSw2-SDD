package Lists;

import java.util.ArrayList;
import Models.FloorRequest;

public class FloorRequestList {
    private ArrayList<FloorRequest> floorRequests;

    public FloorRequestList() {
        this.floorRequests = new ArrayList<FloorRequest>();
    }

    public ArrayList<FloorRequest> index() {
        return this.floorRequests;
    }

    public void add(FloorRequest floorRequest) {
        if (this.floorRequests.isEmpty()) {
            this.floorRequests.add(floorRequest);
            return;
        }

        for (FloorRequest request : this.floorRequests) {
            int requestDestination = floorRequest.getDestination();
            int requestElevator = floorRequest.getElevatorId();

            int currentDestination = request.getDestination();
            int currentElevator = request.getElevatorId();

            if (requestDestination == currentDestination && requestElevator == currentElevator) {
                return;
            }
        }

        this.floorRequests.add(floorRequest);
    }

    public void remove(FloorRequest floorRequest) {
        if (this.floorRequests.isEmpty()) {
            return;
        }

        for (FloorRequest request : this.floorRequests) {
            int requestDestination = floorRequest.getDestination();
            int requestElevator = floorRequest.getElevatorId();

            int currentDestination = request.getDestination();
            int currentElevator = request.getElevatorId();

            if (requestDestination == currentDestination && requestElevator == currentElevator) {
                this.floorRequests.remove(request);
                return;
            }
        }
    }

    public boolean isEmpty() {
        return this.floorRequests.isEmpty();
    }
}
