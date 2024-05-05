package Models;

import java.util.ArrayList;

import Lists.PersonList;

public class Floor implements IModel {
    private int id;
    private String label;
    private PersonList peopleOnFloor;
    private PersonList waitingPeople;
    private boolean access;

    public Floor(int id, String label) {
        this.id = id;
        this.label = label;
        this.access = true;
        peopleOnFloor = new PersonList();
        waitingPeople = new PersonList();
    }

    public int getId() {
        return this.id;
    }

    public ArrayList<Person> getPeopleOnFloor() {
        return this.peopleOnFloor.index();
    }

    public void addPersonOnFloor(Person person) {
        this.peopleOnFloor.add(person);
    }

    public void updatePersonOnFloor(int id, Person updatedPerson) {
        this.peopleOnFloor.update(id, updatedPerson);
    }

    public void removePersonOnFloor(int id) {
        this.peopleOnFloor.delete(id);
    }

    public ArrayList<Person> getWaitingPeople() {
        return this.waitingPeople.index();
    }

    public void addWaitingPerson(Person person) {
        this.waitingPeople.add(person);
    }

    public void removeWaitingPerson(int id) {
        this.waitingPeople.delete(id);
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
