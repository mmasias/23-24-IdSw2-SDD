package src.Views;

import java.util.List;

import src.Models.Floor;

public class PeopleOnFloorView {
    private List<Floor> Floors;

    public PeopleOnFloorView(List<Floor> floors) {
        Floors = floors;
    }

    public String[] render() {
        return getPeopleOnFloorView().split("\n");
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
