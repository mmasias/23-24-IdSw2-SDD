package Models;

import java.util.List;

public class FloorRequest {
    private List<Integer> destinations;

    public FloorRequest() {
    }

    public void addFloorToDestinations(int floor) {
        destinations.add(floor);
    }

    public void removeFloorToDestinations(int floor) {
        if (destinations.contains(floor)) {
            destinations.remove(destinations.indexOf(floor));
        }
    }

    public List<Integer> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<Integer> destinationsList) {
        this.destinations = destinationsList;
    }
}
