package Requests.Elevator;

public class CreateElevator {
    public int Capacity;
    public int PeopleInside;
    public int CurrentFloor;

    public CreateElevator(int capacity, int peopleInside, int currentFloor) {
        Capacity = capacity;
        PeopleInside = peopleInside;
        CurrentFloor = currentFloor;
    }
}
