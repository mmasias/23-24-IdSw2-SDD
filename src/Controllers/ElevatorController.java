package src.Controllers;

import src.Models.*;

import java.util.ArrayList;
import java.util.List;
import src.Enums.Direction;
import src.Lists.FloorsToGoList;

public class ElevatorController {
    Building building;
    int amountFloors;
    int amountElevators;
    Values values;

    public Building update(Building building) {
        this.building = building;
        this.amountFloors = building.getFloors().size();
        this.amountElevators = building.getElevators().size();
        this.values = new Values(amountFloors, amountElevators);

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
                updateElevatorPeople(elevator);
            }
        }
    }

    private void updateElevatorPeople(Elevator elevator) {
        int currentFloorId = elevator.getCurrentFloor();
        Floor currentFloor = this.building.getFloors().get(currentFloorId);

        this.processPeopleInside(elevator, currentFloor);
        this.processWaitingPeople(elevator, currentFloor);

        this.building.updateElevator(elevator);
    }

    private void processWaitingPeople(Elevator elevator, Floor floor) {
        List<Person> waitingPeopleCopy = new ArrayList<>(floor.getWaitingPeople());

        for (int i = 0; i < waitingPeopleCopy.size(); i++) {
            Person personOnFloor = waitingPeopleCopy.get(i);
            if (elevator.getPeopleInside().isEmpty()) {
                this.movePersonToElevator(elevator, floor, personOnFloor);
            } else if (elevator.getPeopleInside().size() < elevator.getCapacity()) {
                this.askPeopleInside(elevator, floor, personOnFloor);
            } else {
                this.requestElevator(floor, personOnFloor);
            }
        }
    }

    private void requestElevator(Floor floor, Person person) {
        ElevatorRequest equivalentRequest = this.values.createElevatorRequest(floor, person);
        ElevatorRequest request = getElevatorRequest(equivalentRequest);
        if (request != null) {
            request.setLinkedToElevator(false);
        } else {
            ControlPanel controlPanel = this.building.getControlPanel();
            controlPanel.addElevatorRequest(equivalentRequest);
            this.building.updateControlPanel(controlPanel);
        }
    }

    private void askPeopleInside(Elevator elevator, Floor floor, Person person) {
        Person personInside = elevator.getPeopleInside().get(0);
        int currentFloor = elevator.getCurrentFloor();
        Direction directionInside = this.values.getDirection(currentFloor, personInside.getDestination());
        Direction directionOutside = this.values.getDirection(currentFloor, person.getDestination());

        if (directionInside == directionOutside) {
            this.movePersonToElevator(elevator, floor, person);
        } else {
            this.requestElevator(floor, person);
        }
    }

    private ElevatorRequest getElevatorRequest(ElevatorRequest elevatorRequest) {
        List<ElevatorRequest> list = building.getControlPanel().getElevatorRequests();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getDirection() == elevatorRequest.getDirection()) {
                return list.get(i);
            }
        }
        return null;
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
        ControlPanel controlPanel = this.building.getControlPanel();
        controlPanel.addFloorRequest(floorRequest);
        this.building.updateControlPanel(controlPanel);
    }

    private void removeElevatorRequest(Person person, Floor floor) {
        ElevatorRequest elevatorRequest = this.values.createElevatorRequest(floor, person);
        ControlPanel controlPanel = this.building.getControlPanel();
        controlPanel.removeElevatorRequest(elevatorRequest);
        this.building.updateControlPanel(controlPanel);
    }

    private void removePersonFromElevator(Elevator elevator, Floor floor, Person person) {
        elevator.removePeopleInside(person.getId());
        person.setDestination(this.values.getRandomFloor(elevator.getCurrentFloor()));
        person.setTimeOnFloor(this.values.getRandomTimeOnFloor(5, 20));
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
}