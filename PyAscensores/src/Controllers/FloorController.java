package Controllers;

import Models.*;
import Enums.Direction;

public class FloorController {
    private Building building;

    public void update(Building building) {
        this.building = building;
        this.updateFloors();
    }

    private void updateFloors() {
        for (int i = 0; i < building.getFloors().size(); i++) {
            Floor floor = building.getFloors().get(i);
            this.updatePeople(floor);
        }
    }

    private void updatePeople(Floor floor) {
        for (int i = 0; i < floor.getPeopleOnFloor().size(); i++) {
            Person person = floor.getPeopleOnFloor().get(i);
            this.updatePerson(floor, person);
        }
    }

    private void updatePerson(Floor floor, Person person) {
        if (person.getTimeOnFloor() == 0) {
            moveToWaitingList(floor, person);
            requestElevator(person);
        } else {
            person.setTimeOnFloor(person.getTimeOnFloor() - 1);
        }
    }

    private void moveToWaitingList(Floor floor, Person person) {
        floor.removePersonOnFloor(person.getId());
        floor.addWaitingPerson(person);
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
