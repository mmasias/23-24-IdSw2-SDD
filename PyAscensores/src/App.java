import java.util.ArrayList;

import Enums.Direction;
import Models.Elevator;
import Views.ElevatorView;

public class App {
    public static void main(String[] args) {
        ArrayList<Elevator> elevators = new ArrayList<Elevator>();
        elevators.add(new Elevator(0, 6, 3));
        elevators.add(new Elevator(1, 6, 5));
        elevators.add(new Elevator(2, 6, 5));
        elevators.add(new Elevator(3, 6, 5));

        elevators.get(0).setDirection(Direction.UP);

        ArrayList<String[]> screen = new ArrayList<String[]>();
        for (Elevator e : elevators) {
            String eView = ElevatorView.render(e, 6);
            String eViewSplit[] = eView.split("\n");
            screen.add(eViewSplit);
        }

        for (int i = 0; i < screen.get(0).length; i++) {
            for (int j = 0; j < screen.size(); j++) {
                System.out.print(" " + screen.get(j)[i]);
            }
            System.out.println();
        }
    }
}
