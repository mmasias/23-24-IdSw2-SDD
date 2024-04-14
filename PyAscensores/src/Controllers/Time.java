package Controllers;

import Models.Building;
import java.util.ArrayList;

public class Time {
    public ArrayList<Building> tick(BuildingController controller) {
        return controller.update();
    }
}
