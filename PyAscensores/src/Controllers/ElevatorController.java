package Controllers;

import java.util.ArrayList;
import Lists.ElevatorList;
import Models.*;
import Enums.Direction;


public class ElevatorController {
    Building building;
    InitialValues initialValues= new InitialValues(5,2);

    public void update(Building building) {
        this.building = building;
        updatePosition();
        updatePeople();
    }

    private void updatePeople() {
        for (int i = 0; i < building.getElevators().size(); i++) {
            Elevator elevator = building.getElevators().get(i);
            if (elevator.getDirection() == Direction.STOP) {
                updateElevatorPeople(elevator);
            }
        }
    }

    private void updateElevatorPeople(Elevator elevator) {
        for (int i = 0; i < building.getFloors().size(); i++) {
            Floor floor = building.getFloors().get(i);
            processWaitingPeople(elevator, floor);
            processPeopleInside(elevator, floor);
        }
    }

    private void processWaitingPeople(Elevator elevator, Floor floor) {
        for (int i = 0; i < floor.getWaitingPeople().size(); i++) {
            Person personOnFloor = floor.getWaitingPeople().get(i);
            if (elevatorHasSpace(elevator) && elevator.getAccess()) {
                movePersonToElevator(elevator, floor, personOnFloor);
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
        building.getControlPanel().addFloorRequest(new FloorRequest(person.getDestination(), elevator.getId()));
    }

    private void removePersonFromElevator(Elevator elevator, Floor floor, Person person) {
        elevator.removePeopleInside(person.getId());
        person.setDestination(initialValues.getRandomFloor());
        person.setTimeOnFloor(initialValues.getRandomTimeOnFloor(0,100));
        floor.addPersonOnFloor(person);
    }

    private void updatePosition() {
        for (int i = 0; i < building.getElevators().size(); i++) {
            Elevator elevator = building.getElevators().get(i);
            if (elevator.getDirection().equals(Direction.DOWN) && elevator.getAccess()) {
                elevator.setCurrentFloor(elevator.getCurrentFloor() - 1);
            } else if (elevator.getDirection().equals(Direction.UP) && elevator.getAccess()) {
                elevator.setCurrentFloor(elevator.getCurrentFloor() + 1);
            } else if (elevator.getDirection().equals(Direction.STOP) && elevator.getAccess()) {
                elevator.setCurrentFloor(elevator.getCurrentFloor());
            }
        }
    }

}
