package Controllers;

public class InitialValues {
    private static int AmountFloors = 0;
    private static int AmountElevators = 0;
    private static int ElevatorCapacity = 0;
    private static int ElevatorFloor = 0;
    private static String Label = "";

    public static int getAmountFloors() {
        return AmountFloors;
    }

    public static void setAmountFloors(int amount) {
        AmountFloors = amount;
    }

    public static int getAmountElevators() {
        return AmountElevators;
    }

    public static void setAmountElevators(int amount) {
        AmountElevators = amount;
    }

    public static int getElevatorCapacity() {
        return ElevatorCapacity;
    }

    public static void setElevatorCapacity(int capacity) {
        ElevatorCapacity = capacity;
    }

    public static int getElevatorFloor() {
        return ElevatorFloor;
    }

    public static void setElevatorFloor(int floor) {
        ElevatorFloor = floor;
    }

    public static String getLabel() {
        return Label;
    }

    public static void setLabel(String label) {
        Label = label;
    }

}
