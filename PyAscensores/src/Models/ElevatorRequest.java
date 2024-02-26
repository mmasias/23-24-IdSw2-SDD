package Models;

import java.util.List;

public class ElevatorRequest {
    private List<Integer> floorsToStop;

    public ElevatorRequest(List<Integer> floorsToStop) {
        this.floorsToStop = floorsToStop;
    }

    public List<Integer> getfloorsToStop() {
        return floorsToStop;
    }

    public void setfloorsToStop(List<Integer> floorsToStop) {
        this.floorsToStop = floorsToStop;
    }
}
