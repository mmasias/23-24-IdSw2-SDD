package Views;

import java.util.ArrayList;
import java.util.List;

import Models.Floor;

public class WaitingPeopleView {
    private List<Floor> Floors;

    public WaitingPeopleView(List<Floor> floors) {
        Floors = floors;
    }

    public ArrayList<String[]> render(ArrayList<String[]> building) {

        String View = getWaitingPeopleViewView();
        String ViewSplit[] = View.split("\n");
        building.add(ViewSplit);

        return building;
    }

    private String getWaitingPeopleViewView() {
        StringBuilder waitingPeopleView = new StringBuilder();

        for (int i = Floors.size() - 1; i >= 0; i--) {
            String peopleOnFloorStr = "__" + Floors.get(i).getWaitingPeople().size() + "__";

            waitingPeopleView.append(peopleOnFloorStr);
            waitingPeopleView.append("\n");
        }

        return waitingPeopleView.toString();
    }
}
