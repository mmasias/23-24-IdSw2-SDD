package Responses;

import Models.IModel;

public class Response {

    public String Message;
    public boolean Success;
    public IModel Data;

    public Response(String message, boolean success, IModel data) {
        Message = message;
        Success = success;
        Data = data;
    }

}
