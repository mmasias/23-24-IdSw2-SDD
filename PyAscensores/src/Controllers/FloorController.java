package Controllers;

import Models.*;

public class FloorController {
    private Building building;
    int amountFloors;
    int amountElevators;
    Values values;

    public Building update(Building building) {
        this.building = building;
        this.amountFloors = building.getFloors().size();
        this.amountElevators = building.getElevators().size();
        this.values = new Values(amountFloors, amountElevators);

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
            this.requestElevator(floor, person);
        } else {
            person.setTimeOnFloor(person.getTimeOnFloor() - 1);
            this.building.getFloors().get(floor.getId()).updatePersonOnFloor(person);
        }
    }

    private void moveToWaitingList(Floor floor, Person person) {
        Floor buildingFloor = this.building.getFloors().get(floor.getId());
        buildingFloor.removePersonOnFloor(person);
        buildingFloor.addWaitingPerson(person);
    }

    private void requestElevator(Floor floor, Person person) {
        ElevatorRequest elevatorRequest = this.values.createElevatorRequest(floor, person);
        this.building.getControlPanel().addElevatorRequest(elevatorRequest);
    }
}