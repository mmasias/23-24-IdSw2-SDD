package Controllers;

import java.util.ArrayList;
import Models.Person;

public class People {

    public static ArrayList<Person> createPeople(int amount, int currentFloor, int destination) {
        ArrayList<Person> people = new ArrayList<Person>();

        for (int i = 0; i < amount; i++) {
            int timeOnFloor = getTimeOnFloor();
            Person person = new Person(timeOnFloor, currentFloor, destination);
            people.add(person);
        }

        return people;
    }

    private static int getTimeOnFloor() {
        // TODO: Implement randomization
        return 5;
    }

}
