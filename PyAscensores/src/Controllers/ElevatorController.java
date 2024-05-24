package Controllers;

import java.util.ArrayList;
import Lists.ElevatorList;
import Models.Elevator;
import Models.ElevatorRequest;
import Enums.Direction;
import Models.Building;
import Models.Person;
import Models.Floor;

public class ElevatorController {

    public void update(Building Building) {
        updatePosition(Building);
        updatePeople(Building);
    }

    private void updatePeople(Building building) {
        for (int i = 0; i < building.getElevators().size(); i++) {
            Elevator elevator = building.getElevators().get(i);
            if (elevator.getDirection() == Direction.STOP) {
                updateElevatorPeople(building, elevator);
            }
        }
    }

    private void updateElevatorPeople(Building building, Elevator elevator) {
        for (int i = 0; i < building.getFloors().size(); i++) {
            Floor floor = building.getFloors().get(i);
            processWaitingPeople(elevator, floor);
            processPeopleInside(elevator, floor);
        }
    }

    private void processWaitingPeople(Elevator elevator, Floor floor) {
        for (int i = 0; i < floor.getWaitingPeople().size(); i++) {
            Person personOnFloor = floor.getWaitingPeople().get(i);
            if (elevatorHasSpace(elevator) && elevator.getAccess() == true) {
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
    }

    private void removePersonFromElevator(Elevator elevator, Floor floor, Person person) {
        elevator.removePeopleInside(person.getId());
        floor.addPersonOnFloor(person);
    }

    private void updatePosition(Building building) {
        for (int i = 0; i < building.getElevators().size(); i++) {
            Elevator elevator = building.getElevators().get(i);
            if (elevator.getDirection().equals(Direction.DOWN) && elevator.getAccess() == true) {
                elevator.setCurrentFloor(elevator.getCurrentFloor() - 1);
            } else if (elevator.getDirection().equals(Direction.UP) & elevator.getAccess() == true) {
                elevator.setCurrentFloor(elevator.getCurrentFloor() + 1);
            } else if (elevator.getDirection().equals(Direction.STOP) & elevator.getAccess() == true) {
                elevator.setCurrentFloor(elevator.getCurrentFloor());
            }
        }
    }

}
