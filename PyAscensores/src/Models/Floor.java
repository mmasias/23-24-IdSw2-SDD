package Models;

import java.util.List;

public class Floor implements IModel {
    String id;
    List<Person> people;
    List<Person> waitingPeople;
    boolean acces;

    public Floor(String id, boolean acces, List<Person> people, List<Person> waitingPeople) {
        this.id = id;
        this.acces = acces;
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
        return acces;
    }

    public void setAcces(boolean acces) {
        this.acces = acces;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public void setWaitingPeople(List<Person> waitingPeople) {
        this.waitingPeople = waitingPeople;
    }

}
