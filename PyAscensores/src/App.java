import java.util.ArrayList;

import Controllers.ElevatorController;
import Models.Building;
import Models.Floor;
import Models.Person;
import Requests.Elevator.CreateElevator;
import Views.BuildingView;

public class App {
    public static void main(String[] args) {
        ArrayList<Floor> floors = new ArrayList<Floor>();

        for (int i = 0; i < 6; i++) {
            CreateElevator request = new CreateElevator(6, 0, 3);
            ElevatorController.create(request);
            ArrayList<Person> people = new ArrayList<Person>();
            Floor floor = new Floor("" + i, true, people, people);
            floors.add(floor);
        }

        Building building = new Building(floors, ElevatorController.readAll().Data);
        BuildingView buildingView = new BuildingView(building);
        buildingView.render();
    }
}
