package Models;

import java.util.ArrayList;
import Lists.*;

public class Building {
    private int id;
    private boolean access;
    private FloorList floors;
    private ElevatorList elevators;
    private PersonList people;
    private ControlPanel controlPanels;

    public Building(int id) {
        this.id = id;
        this.access = true;
        this.floors = new FloorList();
        this.elevators = new ElevatorList();
        this.people = new PersonList();
        this.controlPanels = new ControlPanelList();
    }

    public int getId() {
        return this.id;
    }

    public ArrayList<Floor> getFloors() {
        return this.floors.index();
    }

    public void addFloor(String label) {
        this.floors.create(label);
    }

    public void removeFloor(int id) {
        this.floors.delete(id);
    }

    public ArrayList<Elevator> getElevators() {
        return this.elevators.index();
    }

    public void addElevator(int capacity, int currentFloor) {
        this.elevators.create(capacity, currentFloor);
    }

    public void removeElevator(int id) {
        this.elevators.delete(id);
    }

    public ArrayList<Person> getPeople() {
        return this.people.index();
    }

    public void addPerson(int timeOnFloor, int currentFloor, int destination) {
        this.people.create(timeOnFloor, currentFloor, destination);
    }

    public void removePerson(int id) {
        this.people.delete(id);
    }

    public boolean getAccess() {
        return this.access;
    }

    public void setAccess(boolean access) {
        this.access = access;
    }
	
public ControlPanel controlPanelGet()
{
	return this.ControlPanel;
}
}
