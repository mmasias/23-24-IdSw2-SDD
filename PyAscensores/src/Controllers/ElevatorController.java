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
                this.building.updateElevator(elevator);
            }
        }
    }

    private void updatePeople() {
        for (int i = 0; i < building.getElevators().size(); i++) {
            Elevator elevator = building.getElevators().get(i);
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
            if (elevatorHasSpace(elevator)) {
                movePersonToElevator(elevator, floor, personOnFloor);
            } else {
                this.requestElevator(personOnFloor);
            }
        }
    }

    private void processPeopleInside(Elevator elevator, Floor floor) {
        for (int i = 0; i < elevator.getPeopleInside().size(); i++) {
            Person personInElevator = elevator.getPeopleInside().get(i);
            if (personInElevator.getDestination() == elevator.getCurrentFloor()) {
                removePersonFromElevator(elevator, floor, personInElevator);
            }
        }
    }

    private boolean elevatorHasSpace(Elevator elevator) {
        return elevator.getCapacity() > elevator.getPeopleInside().size();
    }

    private void movePersonToElevator(Elevator elevator, Floor floor, Person person) {
        floor.removeWaitingPerson(person.getId());
        elevator.addPeopleInside(person);
        ControlPanel controlPanel = this.building.getControlPanel();
        FloorRequest floorRequest = new FloorRequest(person.getDestination(), elevator.getId());

        controlPanel.addFloorRequest(floorRequest);

        this.building.updateControlPanel(controlPanel);
        this.building.updateFloor(floor);
        this.building.updateElevator(elevator);
    }

    private void removePersonFromElevator(Elevator elevator, Floor floor, Person person) {
        elevator.removePeopleInside(person.getId());
        person.setDestination(initialValues.getRandomFloor());
        person.setTimeOnFloor(initialValues.getRandomTimeOnFloor(0, 100));
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
            } else if (elevator.getDirection().equals(Direction.STOP)) {
                elevator.setCurrentFloor(elevator.getCurrentFloor());
                this.building.updateElevator(elevator);
            }
        }
    }

    private void requestElevator(Person person) {
        Direction direction = determineDirection(person.getCurrentFloor(), person.getDestination());
        ElevatorRequest elevatorRequest = new ElevatorRequest(person.getCurrentFloor(), direction);
        building.getControlPanel().addElevatorRequest(elevatorRequest);
    }

    private Direction determineDirection(int currentFloor, int destination) {
        return currentFloor < destination ? Direction.UP : Direction.DOWN;
    }

}