package Models;

import java.util.List;

public class Floor {
    int Id;
    String Label;
    List<Person> PeopleOnFloor;
    List<Person> WaitingPeople;
    boolean Access;

    public Floor(int id, String label, List<Person> peopleOnFloor, List<Person> waitingPeople) {
        Id = id;
        Label = label;
        PeopleOnFloor = peopleOnFloor;
        WaitingPeople = waitingPeople;
        Access = true;
    }

    public int getId() {
        return Id;
    }

    public List<Person> getPeopleOnFloor() {
        return PeopleOnFloor;
    }

    public List<Person> getWaitingPeople() {
        return WaitingPeople;
    }

    public boolean getAccess() {
        return Access;
    }

    public void setAcces(boolean access) {
        Access = access;
    }

    public void setPeopleOnFloor(List<Person> people) {
        PeopleOnFloor = people;
    }

    public void setWaitingPeople(List<Person> people) {
        WaitingPeople = people;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
    }

}
