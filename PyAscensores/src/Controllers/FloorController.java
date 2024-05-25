package Controllers;

import Models.*;
import Enums.Direction;

public class FloorController {
    private Building building;

    public Building update(Building building) {
        this.building = building;
        this.updateFloors();
        return this.building;
    }

    private void updateFloors() {
        for (int i = 0; i < building.getFloors().size(); i++) {
            Floor floor = building.getFloors().get(i);
            this.updatePeople(floor);
            this.building.updateFloor(floor);
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
            this.moveToWaitingList(floor, person);
            this.requestElevator(person);
        } else {
            person.setTimeOnFloor(person.getTimeOnFloor() - 1);
            this.building.getFloors().get(floor.getId()).updatePersonOnFloor(person);
        }
    }

    private void moveToWaitingList(Floor floor, Person person) {
        Floor buildingFloor = this.building.getFloors().get(floor.getId());
        buildingFloor.removePersonOnFloor(person.getId());
        buildingFloor.addWaitingPerson(person);
        this.building.updateFloor(buildingFloor);
    }

    private void requestElevator(Person person) {
        Direction direction = determineDirection(person.getCurrentFloor(), person.getDestination());
        ElevatorRequest elevatorRequest = new ElevatorRequest(person.getCurrentFloor(), direction);
        this.building.getControlPanel().addElevatorRequest(elevatorRequest);
    }

    private Direction determineDirection(int currentFloor, int destination) {
        return currentFloor < destination ? Direction.UP : Direction.DOWN;
    }
}
