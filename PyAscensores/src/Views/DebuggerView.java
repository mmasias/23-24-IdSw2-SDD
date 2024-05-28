package Views;

import Enums.Direction;
import Models.Building;
import Models.Person;

public class DebuggerView {
        Building building;
        boolean debuggerMode;

        public DebuggerView(Building building, boolean debuggerMode) {
                this.building = building;
                this.debuggerMode = debuggerMode;
        }

        public void render() {
                if (this.debuggerMode) {
                        System.out.println("DEBUGGER MODE");
                        System.out.println(
                                        "=======================================================================================================");
                        System.out.println("ELEVATORS STATUS");
                        System.out.println(
                                        "=======================================================================================================");
                        System.out.println(
                                        "Elevator ID | Current Floor | People Inside | Capacity | Direction | People Inside IDs | FloorsToGoList");
                        System.out.println(
                                        "=======================================================================================================");
                        for (int i = 0; i < this.building.getElevators().size(); i++) {
                                System.out.print(this.building.getElevators().get(i).getId() + "           | ");
                                System.out.print(this.building.getElevators().get(i).getCurrentFloor()
                                                + "             | ");
                                System.out.print(this.building.getElevators().get(i).getPeopleInside().size()
                                                + "             | ");
                                System.out.print(this.building.getElevators().get(i).getCapacity() + "        | ");
                                System.out.print(this.building.getElevators().get(i).getDirection() + "      | ");
                                System.out.print("[");
                                for (int j = 0; j < this.building.getElevators().get(i).getPeopleInside().size(); j++) {
                                        System.out.print(this.building.getElevators().get(i).getPeopleInside().get(j)
                                                        .getId() + ", ");
                                }
                                System.out.print("]");
                                System.out.print("    |    ");
                                System.out.print("[");
                                for (int j = 0; j < this.building.getElevators().get(i).getFloorsToGoList()
                                                .size(); j++) {
                                        System.out.print(this.building.getElevators().get(i).getFloorsToGoList().get(j)
                                                        + ", ");
                                }
                                System.out.println("]");

                        }
                        System.out.println(
                                        "=======================================================================================================");
                        System.out.println("FLOORS STATUS");
                        System.out.println(
                                        "=======================================================================================================");
                        System.out
                                        .println("Floor ID | People Waiting | People On Floor | People Waiting IDs | People On Floor IDs");
                        System.out.println(
                                        "=======================================================================================================");
                        for (int i = 0; i < this.building.getFloors().size(); i++) {
                                System.out.print(this.building.getFloors().get(i).getId() + "        | ");
                                System.out.print(this.building.getFloors().get(i).getWaitingPeople().size()
                                                + "              | ");
                                System.out.print(this.building.getFloors().get(i).getPeopleOnFloor().size()
                                                + "               | ");
                                System.out.print("[");
                                for (int j = 0; j < this.building.getFloors().get(i).getWaitingPeople().size(); j++) {
                                        System.out.print(this.building.getFloors().get(i).getWaitingPeople().get(j)
                                                        .getId() + ", ");
                                }
                                System.out.print("]");
                                System.out.print("    |    ");
                                System.out.print("[");
                                for (int j = 0; j < this.building.getFloors().get(i).getPeopleOnFloor().size(); j++) {
                                        System.out.print(this.building.getFloors().get(i).getPeopleOnFloor().get(j)
                                                        .getId() + ", ");
                                }
                                System.out.println("]");
                        }
                        System.out.println(
                                        "=======================================================================================================");
                        System.out.println("ELEVATOR REQUESTS PER PERSON");
                        System.out.println(
                                        "=======================================================================================================");
                        for (int j = 0; j < this.building.getFloors().size(); j++) {
                                if (this.building.getFloors().get(j).getWaitingPeople().isEmpty()) {
                                        for (int k = 0; k < this.building.getFloors().get(j).getWaitingPeople()
                                                        .size(); k++) {
                                                Person person = this.building.getFloors().get(j).getWaitingPeople()
                                                                .get(k);
                                                System.out.println(
                                                                "Person " + person.getId()
                                                                                + " is waiting to go to floor "
                                                                                + person.getDestination());
                                        }
                                }
                        }
                        System.out.println(
                                        "=======================================================================================================");
                        System.out.println("FLOORS REQUESTS STATUS");
                        System.out.println(
                                        "=======================================================================================================");
                        System.out.println("Elevator ID | Destination | Direction");
                        System.out.println(
                                        "=======================================================================================================");
                        for (int i = 0; i < this.building.getControlPanel().getFloorRequests().size(); i++) {
                                int elevatorId = this.building.getControlPanel().getFloorRequests().get(i)
                                                .getElevatorId();
                                int destination = this.building.getControlPanel().getFloorRequests().get(i)
                                                .getDestination();
                                int currentFloor = this.building.getElevators().get(elevatorId).getCurrentFloor();
                                System.out
                                                .print(elevatorId + "           | ");
                                System.out.print(destination + "           | ");
                                System.out.println(this.determineDirection(currentFloor, destination));
                        }
                        System.out.println(
                                        "=======================================================================================================");
                        System.out.println("ELEVATORS REQUESTS STATUS");
                        System.out.println(
                                        "=======================================================================================================");
                        System.out.println("Origin | Direction | isLinkedToElevator");
                        System.out.println(
                                        "=======================================================================================================");
                        for (int i = 0; i < this.building.getControlPanel().getElevatorRequests().size(); i++) {
                                System.out
                                                .print(this.building.getControlPanel().getElevatorRequests().get(i)
                                                                .getOrigin() + "      | ");
                                System.out.print(
                                                this.building.getControlPanel().getElevatorRequests().get(i)
                                                                .getDirection() + "       | ");
                                System.out.println(
                                                this.building.getControlPanel().getElevatorRequests().get(i)
                                                                .isLinkedToElevator()
                                                                + "       | ");
                        }
                }
        }

        private Direction determineDirection(int currentFloor, int destination) {
                return currentFloor < destination ? Direction.UP : Direction.DOWN;
        }

}
