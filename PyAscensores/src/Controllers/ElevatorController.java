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
        for (Elevator elevator : building.getElevators()) {
            if (elevator.getDirection() == Direction.STOP) {
                updateElevatorPeople(building, elevator);
            }
        }
    }

    private void updateElevatorPeople(Building building, Elevator elevator) {
        for (Floor floor : building.getFloors()) {
            processWaitingPeople(elevator, floor);
            processPeopleInside(elevator, floor);
        }
    }

    private void processWaitingPeople(Elevator elevator, Floor floor) {
        for (Person person : floor.getWaitingPeople()) {
            if (elevatorHasSpace(elevator) && elevator.getAccess() == true) {
                movePersonToElevator(elevator, floor, person);
            }
        }
    }

    private void processPeopleInside(Elevator elevator, Floor floor) {
        for (Person person : elevator.getPeopleInside()) {
            if (person.getDestination() == elevator.getCurrentFloor()) {
                removePersonFromElevator(elevator, floor, person);
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
        for (Elevator elevator : building.getElevators()) {
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
