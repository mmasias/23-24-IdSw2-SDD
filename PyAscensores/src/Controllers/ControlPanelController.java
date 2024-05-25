package Controllers;

import java.util.ArrayList;

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
        for (Elevator elevator : building.getElevators()) {
            if (elevator.getFloorsToGoList().isEmpty() && elevator.getDirection() != Direction.STOP){
                elevator.setDirection(Direction.STOP);
            } 
            else if (!elevator.getFloorsToGoList().isEmpty()) {
                if (elevator.getCurrentFloor() < elevator.getFloorsToGoList().get(0)) {
                    elevator.setDirection(Direction.UP);
                } else if (elevator.getCurrentFloor() > elevator.getFloorsToGoList().get(0)) {
                    elevator.setDirection(Direction.DOWN);
                }
            }
        }
    }
    private void updateFloorRequests(ControlPanel controlPanel) {
        for (FloorRequest floorRequest : controlPanel.getFloorRequests()) {
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
        int distance = destination-building.getElevators().get(elevatorId).getCurrentFloor();
        if (distance<0) {
            direction = Direction.DOWN;
        } else if (distance>0){
            direction = Direction.UP;            
        }
        return direction;
    }
    private void updateElevatorRequests(ControlPanel controlPanel) {
        for (ElevatorRequest elevatorRequest : controlPanel.getElevatorRequests()) {
            boolean canProcess=processElevatorRequest(elevatorRequest);
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
        for (Elevator elevator : building.getElevators()) {
            int distance = Math.abs(elevator.getCurrentFloor() - origin);            
            if (distance < minDistance && elevator.getDirection() == direction){
                minDistance = distance;
                closestElevatorId = elevator.getId();
            }    
        }
        if (closestElevatorId == -1) {
            closestElevatorId= someoneStopped(building.getElevators(),direction,origin);
        }
        return closestElevatorId;
    }
    private int someoneStopped(ArrayList<Elevator> elevators, Direction direction, int destination) {
        int elevatorId = -1;
        int minDistance = Integer.MAX_VALUE;
        for (Elevator elevator : elevators) {
            int distance = Math.abs(elevator.getCurrentFloor() - destination);            
            if (distance < minDistance && elevator.getDirection() == Direction.STOP && elevator.getAccess()) {
                elevatorId = elevator.getId();
            }
        }
        if(elevatorId != -1){
            elevators.get(elevatorId).setDirection(direction);
        }
        return elevatorId;
    }

    
}