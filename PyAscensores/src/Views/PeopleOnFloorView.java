package Views;

import java.util.ArrayList;
import java.util.List;
import Models.Floor;

public class PeopleOnFloorView {
    private List<Floor> Floors;

    public PeopleOnFloorView(List<Floor> floors) {
        Floors = floors;
    }

    public ArrayList<String[]> render(ArrayList<String[]> building) {
        String View = getPeopleOnFloorView();
        String ViewSplit[] = View.split("\n");
        building.add(ViewSplit);

        return building;
    }

    private String getPeopleOnFloorView() {
        StringBuilder peopleOnFloorView = new StringBuilder();
        for (int i = Floors.size() - 1; i >= 0; i--) {
            String peopleOnFloorStr = "___" + Floors.get(i).getPeopleOnFloor().size() + "_";

            peopleOnFloorView.append(peopleOnFloorStr);
            peopleOnFloorView.append("\n");
        }
        return peopleOnFloorView.toString();
    }
}
