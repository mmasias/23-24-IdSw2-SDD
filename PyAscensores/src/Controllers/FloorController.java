package Controllers;

import Models.*;

import java.util.ArrayList;

import Enums.Direction;

public class FloorController {
    private Building building;

    public Building update(Building building) {
        this.building = building;
        this.updateFloors();
        printfloorsStatus();
        return this.building;
    }

    private void printfloorsStatus() {
        for (int i = 0; i < building.getFloors().size(); i++) {
            Floor floor = building.getFloors().get(i);
            System.out.println("Floor " + floor.getId() + " has " + floor.getPeopleOnFloor().size() + " people on it");
            System.out.println("And " + floor.getWaitingPeople().size() + " people waiting");
            System.out.println("FLOOR "+floor.getId()+" [" +printPeopleOnFloor(floor.getPeopleOnFloor())+ " ]");
            printPeopleWaiting(floor.getWaitingPeople());
        }
    }

    private void printPeopleWaiting(ArrayList<Person> waitingPeople) {
        for (int i = 0; i < waitingPeople.size(); i++) {
            Person person = waitingPeople.get(i);
            System.out.println("Person " + person.getId() + " is waiting to go to floor " + person.getDestination());
        }
    }
    public String printPeopleOnFloor(ArrayList<Person> peopleOnFloor) {
        String people = "";
        for (int i = 0; i < peopleOnFloor.size(); i++) {
            people += "Person " + peopleOnFloor.get(i).getId() + ", ";
        }
        return people;
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
        this.building.updateFloor(buildingFloor);
    }

    private void requestElevator(Floor floor, Person person) {
        Direction direction = determineDirection(floor.getId(), person.getDestination());
        ElevatorRequest elevatorRequest = new ElevatorRequest(floor.getId(), direction);
        this.building.getControlPanel().addElevatorRequest(elevatorRequest);
    }

    private Direction determineDirection(int currentFloor, int destination) {
        return currentFloor < destination ? Direction.UP : Direction.DOWN;
    }
}
