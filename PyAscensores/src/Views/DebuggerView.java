package Views;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import Enums.Direction;
import Models.Building;
import Models.Elevator;
import Models.Person;

public class DebuggerView {
        private Building building;
        private boolean debuggerMode;

        public DebuggerView(Building building, boolean debuggerMode) {
                this.building = building;
                this.debuggerMode = debuggerMode;
        }

        public void render() {
                if (this.debuggerMode) {
                        System.out.println("DEBUGGER MODE");
                        printSeparator();
                        printElevatorsStatus();
                        printSeparator();
                        printFloorsStatus();
                        printSeparator();
                        printElevatorRequestsPerPerson();
                        printSeparator();
                        printFloorRequestsPerPerson();
                        printSeparator();
                        printFloorRequestsStatus();
                        printSeparator();
                        printElevatorsRequestsStatus();
                        printSeparator();
                }
        }

        private void printSeparator() {
                System.out.println(
                                "=======================================================================================================");
        }

        private void printElevatorsStatus() {
                System.out.println("ELEVATORS STATUS");
                System.out.println(
                                "Elevator ID | Current Floor | People Inside | Capacity | Direction | People Inside IDs | FloorsToGoList");
                this.printSeparator();
                building.getElevators().forEach(elevator -> {
                        System.out.print(elevator.getId() + "           | ");
                        System.out.print(elevator.getCurrentFloor() + "             | ");
                        System.out.print(elevator.getPeopleInside().size() + "             | ");
                        System.out.print(elevator.getCapacity() + "        | ");
                        System.out.print(elevator.getDirection() + "      | ");
                        printPeopleInside(elevator.getPeopleInside());
                        System.out.print("    |    ");
                        printFloorsToGoList(elevator);
                        System.out.println();
                });
        }

        private void printPeopleInside(List<Person> peopleInside) {
                System.out.print("[");
                for (Person person : peopleInside) {
                        System.out.print(person.getId() + ", ");
                }
                System.out.print("]");
        }

        private void printFloorsToGoList(Elevator elevator) {
                System.out.print("[");
                for (int i = 0; i < elevator.getFloorsToGoList().size(); i++) {
                        int floor = elevator.getFloorsToGoList().get(i);
                        System.out.print(floor + ", ");
                }
                System.out.print("]");
        }

        private void printFloorsStatus() {
                System.out.println("FLOORS STATUS");
                System.out.println(
                                "Floor ID | People Waiting | People On Floor | People Waiting IDs | People On Floor IDs");
                printSeparator();
                building.getFloors().forEach(floor -> {
                        System.out.print(floor.getId() + "        | ");
                        System.out.print(floor.getWaitingPeople().size() + "              | ");
                        System.out.print(floor.getPeopleOnFloor().size() + "               | ");
                        printPeopleIDs(floor.getWaitingPeople());
                        System.out.print("    |    ");
                        printPeopleIDs(floor.getPeopleOnFloor());
                        System.out.println();
                });
        }

        private void printPeopleIDs(List<Person> people) {
                System.out.print("[");
                for (Person person : people) {
                        System.out.print(person.getId() + ", ");
                }
                System.out.print("]");
        }

        private void printElevatorRequestsPerPerson() {
                System.out.println("ELEVATOR REQUESTS PER PERSON");
                building.getFloors().forEach(floor -> {
                        if (!floor.getWaitingPeople().isEmpty()) {
                                floor.getWaitingPeople().forEach(person -> {
                                        System.out.println("Person " + person.getId() + " is waiting to go to floor "
                                                        + person.getDestination());
                                });
                        }
                });
        }

        private void printFloorRequestsPerPerson() {
                System.out.println("FLOOR REQUESTS PER PERSON");
                building.getElevators().forEach(elevator -> {
                        if (!elevator.getPeopleInside().isEmpty()) {
                                elevator.getPeopleInside().forEach(person -> {
                                        System.out.println("Person " + person.getId() + " is in elevator "
                                                        + elevator.getId() + " going to floor "
                                                        + person.getDestination());
                                });
                        }
                });
        }

        private void printFloorRequestsStatus() {
                System.out.println("FLOOR REQUESTS STATUS");
                System.out.println("Elevator ID | Destination | Direction");
                printSeparator();
                building.getControlPanel().getFloorRequests().forEach(request -> {
                        int elevatorId = request.getElevatorId();
                        int destination = request.getDestination();
                        int currentFloor = building.getElevators().get(elevatorId).getCurrentFloor();
                        System.out.print(elevatorId + "           | ");
                        System.out.print(destination + "           | ");
                        System.out.println(determineDirection(currentFloor, destination));
                });
        }

        private void printElevatorsRequestsStatus() {
                System.out.println("ELEVATORS REQUESTS STATUS");
                System.out.println("Origin | Direction | isLinkedToElevator");
                printSeparator();
                building.getControlPanel().getElevatorRequests().forEach(request -> {
                        System.out.print(request.getOrigin() + "      | ");
                        System.out.print(request.getDirection() + "       | ");
                        System.out.println(request.isLinkedToElevator() + "       | ");
                });
        }

        private Direction determineDirection(int currentFloor, int destination) {
                return currentFloor < destination ? Direction.UP : Direction.DOWN;
        }
}
