package Controllers;

import java.util.ArrayList;
import java.util.List;

import Enums.Direction;
import Models.*;

public class ControlPanelController {
    Building building;

    public void update(Building building) {
        this.building = building;
        updateElevatorDirections();
        updateElevatorRequests(building.getControlPanel());
        updateFloorRequests(building.getControlPanel());
    }

    private void updateElevatorDirections() {
        List<Elevator> elevators = building.getElevators();
        for (int i = 0; i < elevators.size(); i++) {
            Elevator elevator = elevators.get(i);
            if (elevator.getDirection() != Direction.STOP && isElevatorinFloor(elevator)) {
                elevator.getFloorsToGoList().delete(elevator.getCurrentFloor());
                elevator.setDirection(Direction.STOP);
            } else if (!elevator.getFloorsToGoList().isEmpty()) {
                if (elevator.getCurrentFloor() < elevator.getFloorsToGoList().get(0)) {
                    elevator.setDirection(Direction.UP);
                } else if (elevator.getCurrentFloor() > elevator.getFloorsToGoList().get(0)) {
                    elevator.setDirection(Direction.DOWN);
                }
            }
        }
    }

    private boolean isElevatorinFloor(Elevator elevator) {
        for (int i = 0; i < elevator.getFloorsToGoList().size(); i++) {
            if (elevator.getCurrentFloor() == elevator.getFloorsToGoList().get(i)) {
                return true;
            }            
        }
        return false;
    }

    private void updateFloorRequests(ControlPanel controlPanel) {
        List<FloorRequest> floorRequests = new ArrayList<>(controlPanel.getFloorRequests());
        for (int i = 0; i < floorRequests.size(); i++) {
            FloorRequest floorRequest = floorRequests.get(i);
            processFloorRequest(floorRequest);
            controlPanel.removeFloorRequest(floorRequest);
        }
    }

    private void processFloorRequest(FloorRequest floorRequest) {
        int destination = floorRequest.getDestination();
        int elevatorId = floorRequest.getElevatorId();
        Direction direction = getDirection(floorRequest.getDestination(), elevatorId);
        if (direction != Direction.STOP) {
            building.getElevators().get(elevatorId).getFloorsToGoList().add(destination, direction);
        }
    }

    private Direction getDirection(int destination, int elevatorId) {
        Direction direction = Direction.STOP;
        int distance = destination - building.getElevators().get(elevatorId).getCurrentFloor();
        if (distance < 0) {
            direction = Direction.DOWN;
        } else if (distance > 0) {
            direction = Direction.UP;
        }
        return direction;
    }

    private void updateElevatorRequests(ControlPanel controlPanel) {
        List<ElevatorRequest> elevatorRequests = new ArrayList<>(controlPanel.getElevatorRequests());
        for (int i = 0; i < elevatorRequests.size(); i++) {
            ElevatorRequest elevatorRequest = elevatorRequests.get(i);
            boolean canProcess = processElevatorRequest(elevatorRequest);
            if (canProcess) {
                controlPanel.removeElevatorRequest(elevatorRequest);
            }
        }
    }

    private boolean processElevatorRequest(ElevatorRequest elevatorRequest) {
        Direction direction = elevatorRequest.getDirection();
        int origin = elevatorRequest.getOrigin();
        int elevatorId = findClosestElevator(direction, origin);
        if (elevatorId != -1) {
            building.getElevators().get(elevatorId).getFloorsToGoList().add(elevatorId, direction);
            return true;
        }
        return false;
    }

    private int findClosestElevator(Direction direction, int origin) {
        int closestElevatorId = -1;
        int minDistance = Integer.MAX_VALUE;
        List<Elevator> elevators = building.getElevators();
        for (int i = 0; i < elevators.size(); i++) {
            Elevator elevator = elevators.get(i);
            int distance = Math.abs(elevator.getCurrentFloor() - origin);
            if (distance < minDistance && elevator.getDirection() == direction) {
                minDistance = distance;
                closestElevatorId = elevator.getId();
            }
        }
        if (closestElevatorId == -1) {
            closestElevatorId = isSomeoneAvailable(building.getElevators(), direction, origin);
        }
        return closestElevatorId;
    }

    private int isSomeoneAvailable(ArrayList<Elevator> elevators, Direction direction, int destination) {
        int elevatorId = -1;
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < elevators.size(); i++) {
            Elevator elevator = elevators.get(i);
            int distance = Math.abs(elevator.getCurrentFloor() - destination);
            if (distance < minDistance && elevator.getFloorsToGoList().isEmpty() && elevator.getAccess()) {
                elevatorId = elevator.getId();
            }
        }
        if (elevatorId != -1) {
            elevators.get(elevatorId).setDirection(direction);
        }
        return elevatorId;
    }

}