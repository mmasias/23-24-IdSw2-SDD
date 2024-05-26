package Controllers;

import Models.*;
import Enums.Direction;
import Lists.FloorsToGoList;

public class ElevatorController {
    Building building;
    InitialValues initialValues = new InitialValues(5, 3);

    public Building update(Building building) {
        this.building = building;

        this.checkElevatorRequests();
        this.updatePeople();
        this.updatePosition();

        return this.building;
    }

    private void checkElevatorRequests() {
        for (int i = 0; i < building.getElevators().size(); i++) {
            Elevator elevator = building.getElevators().get(i);
            FloorsToGoList floorsToGo = elevator.getFloorsToGoList();
            int currentFloor = elevator.getCurrentFloor();

            if (!floorsToGo.isEmpty() && floorsToGo.get(0) == currentFloor) {
                elevator.setDirection(Direction.STOP);
                elevator.getFloorsToGoList().delete(elevator.getCurrentFloor());
                this.building.updateElevator(elevator);
            }
        }
    }

    private void updatePeople() {
        for (int i = 0; i < this.building.getElevators().size(); i++) {
            Elevator elevator = this.building.getElevators().get(i);
            if (elevator.getDirection() == Direction.STOP) {
                elevator = updateElevatorPeople(elevator);
            }
            this.building.updateElevator(elevator);
        }
    }

    private Elevator updateElevatorPeople(Elevator elevator) {
        int currentFloorId = elevator.getCurrentFloor();
        Floor currentFloor = this.building.getFloors().get(currentFloorId);

        this.processWaitingPeople(elevator, currentFloor);
        this.processPeopleInside(elevator, currentFloor);

        return elevator;
    }

    private void processWaitingPeople(Elevator elevator, Floor floor) {
        for (int i = 0; i < floor.getWaitingPeople().size(); i++) {
            Person personOnFloor = floor.getWaitingPeople().get(i);

            if (!elevator.isFull()) {
                this.movePersonToElevator(elevator, floor, personOnFloor);
            } else {
                ElevatorRequest request = this.getRequestElevator(floor, personOnFloor);
                this.building.getControlPanel().addElevatorRequest(request);
            }
        }
    }

    private void processPeopleInside(Elevator elevator, Floor floor) {
        for (int i = 0; i < elevator.getPeopleInside().size(); i++) {
            Person personInElevator = elevator.getPeopleInside().get(i);
            if (personInElevator.getDestination() == elevator.getCurrentFloor()) {
                this.removePersonFromElevator(elevator, floor, personInElevator);
            }
        }
    }

    private void movePersonToElevator(Elevator elevator, Floor floor, Person person) {
        FloorRequest floorRequest = new FloorRequest(person.getDestination(), elevator.getId());

        this.building.getFloors().get(floor.getId()).removeWaitingPerson(person);
        this.building.addPersonInElevator(elevator.getId(), person);
        this.removeElevatorRequest(person, floor);
        this.building.getControlPanel().addFloorRequest(floorRequest);
    }

    private void removeElevatorRequest(Person person, Floor floor) {
        ElevatorRequest elevatorRequest = this.getRequestElevator(floor, person);
        this.building.getControlPanel().removeElevatorRequest(elevatorRequest);
    }

    private void removePersonFromElevator(Elevator elevator, Floor floor, Person person) {
        elevator.removePeopleInside(person.getId());
        person.setDestination(initialValues.getRandomFloor(elevator.getCurrentFloor()));
        person.setTimeOnFloor(initialValues.getRandomTimeOnFloor(10, 40));
        floor.addPersonOnFloor(person);

        this.building.updateElevator(elevator);
        this.building.updateFloor(floor);
    }

    private void updatePosition() {
        for (int i = 0; i < building.getElevators().size(); i++) {
            Elevator elevator = building.getElevators().get(i);
            if (elevator.getDirection().equals(Direction.DOWN)) {
                elevator.setCurrentFloor(elevator.getCurrentFloor() - 1);
                this.building.updateElevator(elevator);
            } else if (elevator.getDirection().equals(Direction.UP)) {
                elevator.setCurrentFloor(elevator.getCurrentFloor() + 1);
                this.building.updateElevator(elevator);
            }
        }
    }

    private ElevatorRequest getRequestElevator(Floor floor, Person person) {
        Direction direction = determineDirection(floor.getId(), person.getDestination());
        return new ElevatorRequest(floor.getId(), direction);
    }

    private Direction determineDirection(int currentFloor, int destination) {
        return currentFloor < destination ? Direction.UP : Direction.DOWN;
    }

    private boolean isElevatorInFloor(Elevator elevator) {
        for (int i = 0; i < elevator.getFloorsToGoList().size(); i++) {
            if (elevator.getCurrentFloor() == elevator.getFloorsToGoList().get(i)) {
                return true;
            }
        }
        return false;
    }

}