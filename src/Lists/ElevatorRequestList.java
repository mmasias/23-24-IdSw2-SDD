package src.Lists;

import java.util.ArrayList;

import src.Enums.Direction;
import src.Models.ElevatorRequest;

public class ElevatorRequestList {
    private ArrayList<ElevatorRequest> elevatorRequests;

    public ElevatorRequestList() {
        this.elevatorRequests = new ArrayList<ElevatorRequest>();
    }

    public ArrayList<ElevatorRequest> index() {
        return this.elevatorRequests;
    }

    public void add(ElevatorRequest elevatorRequest) {
        if (this.elevatorRequests.isEmpty()) {
            this.elevatorRequests.add(elevatorRequest);
            return;
        }

        for (ElevatorRequest request : this.elevatorRequests) {
            int requestOrigin = elevatorRequest.getOrigin();
            Direction requestDirection = elevatorRequest.getDirection();

            int currentOrigin = request.getOrigin();
            Direction currentDirection = request.getDirection();

            if (requestOrigin == currentOrigin && requestDirection == currentDirection) {
                return;
            }
        }

        this.elevatorRequests.add(elevatorRequest);
    }

    public void remove(ElevatorRequest elevatorRequest) {
        if (this.elevatorRequests.isEmpty()) {
            return;
        }

        for (ElevatorRequest request : this.elevatorRequests) {
            int requestOrigin = elevatorRequest.getOrigin();
            Direction requestDirection = elevatorRequest.getDirection();

            int currentOrigin = request.getOrigin();
            Direction currentDirection = request.getDirection();

            if (requestOrigin == currentOrigin && requestDirection == currentDirection) {
                this.elevatorRequests.remove(request);
                return;
            }
        }
    }

    public boolean isEmpty() {
        return this.elevatorRequests.isEmpty();
    }

}
