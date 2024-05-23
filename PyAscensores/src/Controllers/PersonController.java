package Controllers;

import Models.Building;
import Models.Person;
import Models.Floor;
import Models.ControlPanel;
import Models.ElevatorRequest;
import Models.FloorRequest;
import Enums.Direction;

public class PersonController {
    private Building building;
    private ControlPanel controlPanel;

    public PersonController(Building building, ControlPanel controlPanel) {
        this.building = building;
        this.controlPanel = controlPanel;
    }

    public void update() {
        building.getFloors().forEach(this::updateFloor);
    }

    private void updateFloor(Floor floor) {
        floor.getPeopleOnFloor().forEach(person -> updatePerson(floor, person));
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
        FloorRequest floorRequest = new FloorRequest(person.getDestination(), direction);
        controlPanel.addElevatorRequest(elevatorRequest);
        controlPanel.addFloorRequest(floorRequest);
    }

    private Direction determineDirection(int currentFloor, int destination) {
        return currentFloor < destination ? Direction.UP : Direction.DOWN;
    }
}
