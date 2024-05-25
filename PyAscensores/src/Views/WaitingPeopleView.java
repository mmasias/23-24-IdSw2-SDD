package Views;

import java.util.List;

import Models.Floor;

public class WaitingPeopleView {
    private List<Floor> floors;

    public WaitingPeopleView(List<Floor> floors) {
        this.floors = floors;
    }

    public String[] render() {
        String view[] = getWaitingPeopleViewView().split("\n");

        return view;
    }

    private String getWaitingPeopleViewView() {
        StringBuilder waitingPeopleView = new StringBuilder();
        for (int i = floors.size() - 1; i >= 0; i--) {
            String peopleOnFloorStr = "___" + floors.get(i).getWaitingPeople().size() + "_";

            waitingPeopleView.append(peopleOnFloorStr);
            waitingPeopleView.append("\n");
        }
        return waitingPeopleView.toString();
    }
}
