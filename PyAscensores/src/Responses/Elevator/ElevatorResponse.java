package Responses.Elevator;

import Models.Elevator;
import java.util.ArrayList;

public class ElevatorResponse {
    public String Message;
    public boolean Success;
    public ArrayList<Elevator> Data;

    public ElevatorResponse(String message, boolean success, ArrayList<Elevator> data) {
        Message = message;
        Success = success;
        Data = data;
    }
}
