package Controllers;

import Models.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Enums.Direction;
import Lists.FloorsToGoList;

public class ElevatorController {
    Building building;
    InitialValues initialValues = new InitialValues(5, 3);

    public Building update(Building building) {
        this.building = building;

        this.checkElevatorRequests();
        this.updatePeople();
        this.updatePosition();
        printElevatorPeople();
        return this.building;
    }

    private void printElevatorPeople() {
        for (int i = 0; i < building.getElevators().size(); i++) {
            Elevator elevator = building.getElevators().get(i);
            System.out.println("Elevator " + elevator.getId() + " is in floor " + elevator.getCurrentFloor()
                    + " and is going " + elevator.getDirection() + " with " + elevator.getPeopleInside().size()
                    + " people inside" + " and has a capacity of " + elevator.getCapacity() + " people"
                    + " and this people are " + printPeople(elevator.getPeopleInside()));

        }
    }

    private String printPeople(ArrayList<Person> peopleInside) {
        String people = "[";
        for (int i = 0; i < peopleInside.size(); i++) {
            Person person = peopleInside.get(i);
            people+= ("Person " + person.getId() +", ");
        }
        people += "]";
        return people;
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
        
        this.processWaitingPeople(elevator, currentFloor);
        this.processPeopleInside(elevator, currentFloor);
        
        this.building.updateElevator(elevator);
    }

    private void processWaitingPeople(Elevator elevator, Floor floor) {
        System.out.println("HAY "+floor.getWaitingPeople().size()+" personas en el piso "+floor.getId());
        List<Person> waitingPeopleCopy = new ArrayList<>(floor.getWaitingPeople());
        
        for (int i = 0; i < waitingPeopleCopy.size(); i++) {
            System.out.println("gen "+i);
            Person personOnFloor = waitingPeopleCopy.get(i);
            System.out.println("Elevator "+elevator.getId() +" GEnte: "+elevator.getPeopleInside().size());

            if (elevator.getPeopleInside().size()<=6) {
                System.out.println("Person " + personOnFloor.getId() + " is going to elevator " + elevator.getId() + " in floor " + floor.getId());
                this.movePersonToElevator(elevator, floor, personOnFloor);

            }
            else {
                ElevatorRequest equivalentRequest= getRequestElevator(floor, personOnFloor);
                ElevatorRequest request= getElevatorRequest(equivalentRequest);
                if(request != null) {
                    request.setLinkedToElevator(false);
                } else {

                    ControlPanel controlPanel = this.building.getControlPanel();
                    controlPanel.addElevatorRequest(equivalentRequest);
                    this.building.updateControlPanel(controlPanel);
                }
            }
           
        }
    }

    private ElevatorRequest getElevatorRequest(ElevatorRequest elevatorRequest) {
        ArrayList<ElevatorRequest> list= building.getControlPanel().getElevatorRequests();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getDirection() == elevatorRequest.getDirection()&& list.get(i).getDirection() == elevatorRequest.getDirection()){
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
        ElevatorRequest elevatorRequest = this.getRequestElevator(floor, person);
        ControlPanel controlPanel = this.building.getControlPanel();
        controlPanel.removeElevatorRequest(elevatorRequest);
        this.building.updateControlPanel(controlPanel);
    }

    private void removePersonFromElevator(Elevator elevator, Floor floor, Person person) {
        elevator.removePeopleInside(person.getId());
        person.setDestination(initialValues.getRandomFloor(elevator.getCurrentFloor()));
        person.setTimeOnFloor(initialValues.getRandomTimeOnFloor(10, 40));
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

    private ElevatorRequest getRequestElevator(Floor floor, Person person) {
        Direction direction = determineDirection(floor.getId(), person.getDestination());
        return new ElevatorRequest(floor.getId(), direction);
    }

    private Direction determineDirection(int currentFloor, int destination) {
        return currentFloor < destination ? Direction.UP : Direction.DOWN;
    }

    private boolean isElevatorInFloor(Elevator elevator) {
        for (int i = 0; i < elevator.getFloorsToGoList().size(); i++) {
            if (elevator.getCurrentFloor() == elevator.getFloorsToGoList().get(i)) {
                return true;
            }
        }
        return false;
    }

}