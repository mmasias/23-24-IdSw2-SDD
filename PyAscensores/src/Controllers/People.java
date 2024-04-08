package Controllers;

import java.util.ArrayList;
import Models.Person;

public class People {

    private static ArrayList<Person> people;

    public static ArrayList<Person> index() {
        return people;
    }

    public static Person get(int index) {
        if (index >= 0 && index < people.size()) {
            return people.get(index);
        }
        return null;
    }

    public static void create(int timeOnFloor, int currentFloor, int destination) {
        people.add(new Person(people.size(), timeOnFloor, currentFloor, destination));
    }

    public static void update(int id, Person updatedPerson) {
        if (id >= 0 && id < people.size()) {
            people.set(id, updatedPerson);
        }
    }

    public static void delete(int id) {
        if (id >= 0 && id < people.size()) {
            people.remove(id);
        }
    }
}
