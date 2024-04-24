package Models;

import java.util.ArrayList;

public class Floor {
    private int id;
    private String label;
    private ArrayList<Integer> peopleOnFloor;
    private ArrayList<Integer> waitingPeople;
    private boolean access;

    public Floor(int id, String label) {
        this.id = id;
        this.label = label;
        this.access = true;
        peopleOnFloor = new ArrayList<Integer>();
        waitingPeople = new ArrayList<Integer>();
    }

    public int getId() {
        return this.id;
    }

    public ArrayList<Integer> getPeopleOnFloor() {
        return this.peopleOnFloor;
    }

    public void addPersonOnFloor(int person) {
        this.peopleOnFloor.add(person);
    }

    public void removePersonOnFloor(int person) {
        this.peopleOnFloor.remove(person);
    }

    public ArrayList<Integer> getWaitingPeople() {
        return this.waitingPeople;
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
