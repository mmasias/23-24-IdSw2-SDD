package src.Views;

import java.util.List;

import src.Models.Floor;

public class FloorView {
    private List<Floor> Floors;

    public FloorView(List<Floor> floors) {
        Floors = floors;
    }

    public String[] render() {
        String view[] = getFloorView().split("\n");

        return view;
    }

    private String getFloorView() {
        StringBuilder floorView = new StringBuilder();

        for (int i = Floors.size() - 1; i >= 0; i--) {
            String floorStr = Floors.get(i).getLabel();
            floorView.append(floorStr);
            floorView.append("\n");
        }

        return floorView.toString();
    }
}
