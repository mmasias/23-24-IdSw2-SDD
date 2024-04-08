package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Floor {
    private int id;
    private String label;
    private Set<Integer> peopleOnFloor;
    private Set<Integer> waitingPeople;
    private boolean access;

    public Floor(int id, String label) {
        this.id = id;
        this.label = label;
        this.access = true;
    }

    public int getId() {
        return this.id;
    }

    public ArrayList<Integer> getPeopleOnFloor() {
        return new ArrayList<>(this.peopleOnFloor);
    }

    public void addPersonOnFloor(int person) {
        this.peopleOnFloor.add(person);
    }

    public void removePersonOnFloor(int person) {
        this.peopleOnFloor.remove(person);
    }

    public ArrayList<Integer> getWaitingPeople() {
        return new ArrayList<>(this.waitingPeople);
    }

    public void addWaitingPerson(int person) {
        this.waitingPeople.add(person);
    }

    public void removeWaitingPerson(int person) {
        this.waitingPeople.remove(person);
    }

    public boolean getAccess() {
        return this.access;
    }

    public void setAccess(boolean access) {
        this.access = access;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}
