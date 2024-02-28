package Controllers;

import Requests.Elevator.CreateElevator;
import Models.Elevator;
import Responses.Response;
import Responses.Elevator.ElevatorResponse;
import Repository.ElevatorRepository;
import java.util.ArrayList;

public class ElevatorController implements IController {

    public static Response create(CreateElevator request) {
        try {
            Elevator elevator = ElevatorRepository.create(request.Capacity, request.CurrentFloor);
            return new Response("Elevator created", true, elevator);
        } catch (Exception e) {
            return new Response(e.getMessage(), false, null);
        }
    }

    public static Response read(int id) {
        try {
            return new Response("Elevator read", true, ElevatorRepository.read(id));
        } catch (Exception e) {
            return new Response(e.getMessage(), false, null);
        }
    }

    public static ElevatorResponse readAll() {
        try {
            ArrayList<Elevator> elevators = ElevatorRepository.readAll();
            return new ElevatorResponse("Elevators read", true, elevators);
        } catch (Exception e) {
            return new ElevatorResponse(e.getMessage(), false, null);
        }
    }
}
