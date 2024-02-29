package Controllers;

import java.util.ArrayList;

import Models.Floor;
import Models.Person;

public class Floors {

    private static ArrayList<Floor> Floors = new ArrayList<Floor>();

    public static ArrayList<Floor> createFloors(int amount, String Label) {
        for (int i = 0; i < amount; i++) {
            ArrayList<Person> peopleOnFloor = People.createPeople(setAmountOfPeople(), i, setDestination());
            ArrayList<Person> peopleWaiting = People.createPeople(setAmountOfPeople(), i, setDestination());
            Floor floor = new Floor(i, Label + i, peopleOnFloor, peopleWaiting);
            Floors.add(floor);
        }
        return Floors;
    }

    public static ArrayList<Floor> getFloors() {
        return Floors;
    }

    private static int setAmountOfPeople() {
        // TODO: Implement randomization
        return 1;
    }

    public static int setDestination() {
        // TODO: Implement randomization
        return 3;
    }

}
