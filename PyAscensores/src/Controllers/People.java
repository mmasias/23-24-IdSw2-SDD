package Controllers;

import java.util.ArrayList;
import Models.Person;

public class People {

    private ArrayList<Person> peopleList;

    public People() {
        this.peopleList = new ArrayList<>();
    }

    public void create(Person person) {
        this.peopleList.add(person);
    }

    public void update(int index, Person updatedPerson) {
        if (index >= 0 && index < this.peopleList.size()) {
            this.peopleList.set(index, updatedPerson);
        } else {
            System.out.println("Índice fuera de rango.");
        }
    }

    public void delete(int index) {
        if (index >= 0 && index < this.peopleList.size()) {
            this.peopleList.remove(index);
        } else {
            System.out.println("Índice fuera de rango.");
        }
    }

    public ArrayList<Person> index() {
        return this.peopleList;
    }

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
        // TODO: Implementar la aleatorización
        return 5;
    }
}
