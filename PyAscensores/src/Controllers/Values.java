package Controllers;

import Enums.Direction;
import Models.ElevatorRequest;
import Models.Floor;
import Models.Person;

public class Values {
    private int amountFloors;
    private int amountElevators;
    private int elevatorCapacity = -1;
    private int elevatorFloor = -1;
    private int amountPeople = -1;
    private String label = null;

    public Values(int amountFloors, int amountElevators) {
        this.amountFloors = amountFloors;
        this.amountElevators = amountElevators;
    }

    public int getAmountFloors() {
        return this.amountFloors;
    }

    public int getAmountElevators() {
        return this.amountElevators;
    }

    public int getElevatorCapacity() {
        if (this.elevatorCapacity == -1) {
            return this.randomInt(5, 10);
        }
        return this.elevatorCapacity;
    }

    public void setElevatorCapacity(int capacity) {
        this.elevatorCapacity = capacity;
    }

    public int getElevatorFloor() {
        if (this.elevatorFloor == -1) {
            return this.randomInt(0, this.amountFloors - 1);
        }
        return this.elevatorFloor;
    }

    public void setElevatorFloor(int floor) {
        elevatorFloor = floor;
    }

    public String getLabel() {
        if (this.label == null) {
            return "Planta ";
        }
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getAmountPeople(int min, int max) {
        if (this.amountPeople == -1) {
            int minimum = this.amountFloors * min;
            int maximum = this.amountFloors * max;
            return this.randomInt(minimum, maximum);
        }
        return this.amountPeople;
    }

    public void setAmountPeople(int amountPeople) {
        this.amountPeople = amountPeople;
    }

    private int randomInt(int minimum, int maximum) {
        return minimum + (int) (Math.random() * ((maximum - minimum) + 1));
    }

    public int getRandomTimeOnFloor(int minimum, int maximum) {
        return this.randomInt(minimum, maximum);
    }

    public int getRandomFloor() {
        return this.randomInt(0, this.amountFloors - 1);
    }

    public int getRandomFloor(int excludedFloor) {
        int floor;
        do {
            floor = this.randomInt(0, this.amountFloors - 1);
        } while (floor == excludedFloor);
        return floor;
    }

    public Direction getDirection(int currentFloor, int destination) {
        return currentFloor < destination ? Direction.UP : Direction.DOWN;
    }

    public ElevatorRequest createElevatorRequest(Floor floor, Person person) {
        Direction direction = this.getDirection(floor.getId(), person.getDestination());
        return new ElevatorRequest(floor.getId(), direction);
    }

}