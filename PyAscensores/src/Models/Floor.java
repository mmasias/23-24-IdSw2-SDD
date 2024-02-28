package Models;

import java.util.List;

public class Floor implements IModel {
    String id;
    List<Person> people;
    List<Person> waitingPeople;
    boolean access;

    public Floor(String id, boolean access, List<Person> people, List<Person> waitingPeople) {
        this.id = id;
        this.access = access;
        this.people = people;
        this.waitingPeople = waitingPeople;

    }

    public String getId() {
        return id;
    }

    public List<Person> getPeople() {
        return people;
    }

    public List<Person> getWaitingPeople() {
        return waitingPeople;
    }

    public boolean getAccess() {
        return access;
    }

    public void setAcces(boolean acces) {
        this.access = acces;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public void setWaitingPeople(List<Person> waitingPeople) {
        this.waitingPeople = waitingPeople;
    }

}
