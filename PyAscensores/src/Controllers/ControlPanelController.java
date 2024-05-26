package Controllers;

import java.util.ArrayList;
import java.util.List;

import Enums.Direction;
import Lists.FloorsToGoList;
import Models.*;

public class ControlPanelController {
    Building building;

    public Building update(Building building) {
        this.building = building;

        this.updateElevatorRequests();
        this.updateFloorRequests();
        this.updateElevatorDirections();
        printElvatorsStatus();

        return this.building;
    }

    private void printElvatorsStatus() {
        List<Elevator> elevators = building.getElevators();
        for (int i = 0; i < elevators.size(); i++) {
            Elevator elevator = elevators.get(i);
            System.out.println("Elevator " + elevator.getId() + " is in floor " + elevator.getCurrentFloor()
                    + " and is going " + elevator.getDirection() + " with " + elevator.getPeopleInside().size()
                    + " people inside" + " and has a capacity of " + elevator.getCapacity() + " people");
            System.out.println(
                    "Elevator " + elevator.getId() + " has to go to " + printList(elevator.getFloorsToGoList()));

        }
    }

    private String printList(FloorsToGoList floorsToGoList) {
        String list = "";
        for (int i = 0; i < floorsToGoList.size(); i++) {
            list += floorsToGoList.get(i) + ", ";
        }
        return list;
    }

    private void updateElevatorDirections() {
        List<Elevator> elevators = this.building.getElevators();
        for (int i = 0; i < elevators.size(); i++) {
            Elevator elevator = elevators.get(i);
            int currentFloor = elevator.getCurrentFloor();
            if (elevator.getDirection() != Direction.STOP && elevator.getFloorsToGoList().get(0) == currentFloor) {
                elevator.setDirection(Direction.STOP);
                // elevator.getFloorsToGoList().delete(elevator.getCurrentFloor());

                this.building.updateElevator(elevator);
            } else if (!elevator.getFloorsToGoList().isEmpty()) {
                this.setDirection(elevator);
            }
        }
    }

    private void setDirection(Elevator elevator) {
        if (elevator.getCurrentFloor() < elevator.getFloorsToGoList().get(0)) {
            elevator.setDirection(Direction.UP);

            this.building.updateElevator(elevator);
        } else if (elevator.getCurrentFloor() > elevator.getFloorsToGoList().get(0)) {
            elevator.setDirection(Direction.DOWN);

            this.building.updateElevator(elevator);
        }
    }

    private boolean isElevatorInFloor(Elevator elevator) {
        for (int i = 0; i < elevator.getFloorsToGoList().size(); i++) {
            if (elevator.getCurrentFloor() == elevator.getFloorsToGoList().get(i)) {
                return true;
            }
        }
        return false;
    }

    private void updateFloorRequests() {
        ControlPanel controlPanel = this.building.getControlPanel();
        List<FloorRequest> floorRequests = new ArrayList<>(controlPanel.getFloorRequests());
        for (int i = 0; i < floorRequests.size(); i++) {
            System.out.println("Floor request: " + floorRequests.get(i).getDestination() + " Elevator: "
                    + floorRequests.get(i).getElevatorId());
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

    private void updateElevatorRequests() {
        ControlPanel controlPanel = this.building.getControlPanel();
        List<ElevatorRequest> elevatorRequests = new ArrayList<>(controlPanel.getElevatorRequests());
        for (int i = 0; i < elevatorRequests.size(); i++) {
            System.out.println("Elevator request: " + elevatorRequests.get(i).getOrigin() + " "
                    + elevatorRequests.get(i).getDirection());
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
            building.getElevators().get(elevatorId).getFloorsToGoList().add(origin, direction);
            return true;
        }
        return false;
    }

    private int findClosestElevator(Direction direction, int origin) {
        int closestElevatorId = -1;
        int minDistance = Integer.MAX_VALUE;
        List<Elevator> elevators = building.getElevators();
        closestElevatorId = isSomeoneAvailable(building.getElevators(), direction, origin);
        if (closestElevatorId == -1) {
            for (int i = 0; i < elevators.size(); i++) {
                Elevator elevator = elevators.get(i);
                int distance = Math.abs(elevator.getCurrentFloor() - origin);
                if (distance < minDistance && elevator.getDirection() == direction) {
                    minDistance = distance;
                    closestElevatorId = elevator.getId();
                }
            }
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
            elevators.get(elevatorId).setDirection(getDirection(destination, elevatorId));
        }
        return elevatorId;
    }
}