package Controllers;

import Models.Building;
import Models.Person;
import Models.Floor;
import Models.ControlPanel;
import Models.ElevatorRequest;
import Enums.Direction;

public class PersonController {
    private Building building;
    private ControlPanel controlPanel;

    public PersonController(Building building, ControlPanel controlPanel) {
        this.building = building;
        this.controlPanel = controlPanel;
    }

    public void update() {
        for (Floor floor : building.getFloors()) {
            for (Person person : floor.getPeopleOnFloor()) { 
                if (person.getTimeOnFloor() == 0) {
                    floor.addWaitingPerson(person);
                    Direction direction = determineDirection(person.getCurrentFloor(), person.getDestination());
                    ElevatorRequest request = new ElevatorRequest(person.getCurrentFloor(), direction);
                    controlPanel.elevatorRequest(request);
                } else {
                    person.setTimeOnFloor(person.getTimeOnFloor() - 1);
                }
            }
        }
    }

    private Direction determineDirection(int currentFloor, int destination) {
        return currentFloor < destination ? Direction.UP : Direction.DOWN;
    }
}
