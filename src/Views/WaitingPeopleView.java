package src.Views;

import java.util.List;

import src.Models.Floor;

public class WaitingPeopleView {
    private List<Floor> floors;

    public WaitingPeopleView(List<Floor> floors) {
        this.floors = floors;
    }

    public String[] render() {
        return getWaitingPeopleViewView().split("\n");
    }

    private String getWaitingPeopleViewView() {
        StringBuilder waitingPeopleView = new StringBuilder();
        for (int i = floors.size() - 1; i >= 0; i--) {
            int peopleWaitingOnFloor = floors.get(i).getWaitingPeople().size();
            String peopleOnFloorStr = "___" + peopleWaitingOnFloor + (peopleWaitingOnFloor > 9 ? "_" : "_ ");

            waitingPeopleView.append(peopleOnFloorStr);
            waitingPeopleView.append("\n");
        }
        return waitingPeopleView.toString();
    }
}
