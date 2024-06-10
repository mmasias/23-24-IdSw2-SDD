package src.Models;

import java.util.ArrayList;
import src.Lists.*;

public class Building {
    private FloorList floors;
    private ElevatorList elevators;
    private ControlPanel controlPanel;
    private Counters counters;

    public Building() {
        this.floors = new FloorList();
        this.elevators = new ElevatorList();
        this.controlPanel = new ControlPanel();
        this.counters = new Counters();
    }

    public ArrayList<Floor> getFloors() {
        return this.floors.index();
    }

    public void addFloor(String label) {
        this.floors.create(counters.getFloorCounter(), label);
        counters.incrementFloorCounter();
    }

    public void updateFloor(Floor floor) {
        this.floors.update(floor.getId(), floor);
    }

    public void removeFloor(int id) {
        this.floors.delete(id);
    }

    public ArrayList<Elevator> getElevators() {
        return this.elevators.index();
    }

    public void addElevator(int capacity, int currentFloor) {
        this.elevators.create(counters.getElevatorCounter(), capacity, currentFloor);
        counters.incrementElevatorCounter();
    }

    public void updateElevator(Elevator elevator) {
        this.elevators.update(elevator.getId(), elevator);
    }

    public void removeElevator(int id) {
        this.elevators.delete(id);
    }

    public ControlPanel getControlPanel() {
        return this.controlPanel;
    }

    public void updateControlPanel(ControlPanel controlPanel) {
        this.controlPanel = controlPanel;
    }

    public void addPersonInElevator(int elevatorId, Person person) {
        this.elevators.get(elevatorId).addPeopleInside(person);
        counters.incrementPersonCounter();
    }

    public void addPersonOnFloor(int timeOnFloor, int currentFloor, int destination) {
        Person person = new Person(counters.getPersonCounter(), timeOnFloor, destination);
        this.floors.get(currentFloor).addPersonOnFloor(person);
        counters.incrementPersonCounter();
    }

}