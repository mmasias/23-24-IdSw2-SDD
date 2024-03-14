package Views;

import java.util.ArrayList;
import java.util.List;
import Models.Floor;

public class FloorView {
    private List<Floor> Floors;

    public FloorView(List<Floor> floors) {
        Floors = floors;
    }

    public ArrayList<String[]> render(ArrayList<String[]> building) {
        String View = getFloorView();
        String ViewSplit[] = View.split("\n");
        building.add(ViewSplit);

        return building;
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
