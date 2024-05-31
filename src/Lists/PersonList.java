package src.Lists;

import java.util.ArrayList;
import src.Models.Person;

public class PersonList {
    private ModelList<Person> people;

    public PersonList() {
        this.people = new ModelList<Person>();
    }

    public ArrayList<Person> index() {
        return this.people.index();
    }

    public Person get(int index) {
        return this.people.get(index);
    }

    public void create(int id, int timeOnFloor, int destination) {
        this.people.add(new Person(id, timeOnFloor, destination));
    }

    public void update(int id, Person updatedPerson) {
        this.people.update(id, updatedPerson);
    }

    public void delete(int id) {
        this.people.delete(id);
    }

    public void add(Person person) {
        this.people.add(person);
    }
}