package Views;

import java.util.List;

import Models.Floor;

public class PeopleOnFloorView {
    private List<Floor> Floors;

    public PeopleOnFloorView(List<Floor> floors) {
        Floors = floors;
    }

    public String[] render() {
        String view[] = getPeopleOnFloorView().split("\n");

        return view;
    }

    private String getPeopleOnFloorView() {
        StringBuilder peopleOnFloorView = new StringBuilder();
        for (int i = Floors.size() - 1; i >= 0; i--) {
            String peopleOnFloorStr = "__" + Floors.get(i).getPeopleOnFloor().size() + "__";

            peopleOnFloorView.append(peopleOnFloorStr);
            peopleOnFloorView.append("\n");
        }
        return peopleOnFloorView.toString();
    }
}
