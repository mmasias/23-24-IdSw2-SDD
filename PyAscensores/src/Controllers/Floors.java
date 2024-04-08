package Controllers;

import java.util.ArrayList;

import Models.Elevator;
import Models.Floor;
import Models.Person;

public class Floors {

    private static ArrayList<Floor> Floors = new ArrayList<Floor>();

    public static ArrayList<Floor> createFloors(int amount, String label) {
        for (int i = 0; i < amount; i++) {
            ArrayList<Person> peopleOnFloor = People.createPeople(2, i, 1);
            ArrayList<Person> peopleWaiting = People.createPeople(2, i, 1);
            Floor floor = new Floor(i, label + i, peopleOnFloor, peopleWaiting);
            Floors.add(floor);
        }
        return Floors;
    }

    public static ArrayList<Floor> getFloors() {
        return Floors;
    }

    public static ArrayList<Floor> index() {
        return Floors;
    }

    public static void update(int id, String label, ArrayList<Person> peopleOnFloor, ArrayList<Person> waitingPeople) {
        Floors.get(id).setLabel(label);
        Floors.get(id).setPeopleOnFloor(peopleOnFloor);
        Floors.get(id).setWaitingPeople(waitingPeople);

    }

    public static void delete(int id) {
        Floors.remove(Floors.get(id));

    }

}
