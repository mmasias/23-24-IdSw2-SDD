package Lists;

import java.util.ArrayList;
import Models.Person;

public class PersonList {
    private ArrayList<Person> people;
    private int counter;

    public PersonList() {
        this.people = new ArrayList<Person>();
        this.counter = 0;
    }

    public ArrayList<Person> index() {
        return this.people;
    }

    public Person get(int index) {
        if (index >= 0 && index <= this.counter) {
            for (Person person : this.people) {
                if (person.getId() == index) {
                    return person;
                }
            }
        }
        return null;
    }

    public void create(int timeOnFloor, int currentFloor, int destination) {
        this.people.add(new Person(this.counter, timeOnFloor, currentFloor, destination));
        this.counter++;
    }

    public void update(int id, Person updatedPerson) {
        if (id >= 0 && id <= this.counter) {
            this.people.set(id, updatedPerson);
        }
    }

    public void delete(int id) {
        if (id >= 0 && id <= this.people.size()) {
            this.people.remove(id);
        }
    }
}
