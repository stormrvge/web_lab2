package model;

import java.util.LinkedList;

public class Table {
    private static LinkedList<Response> responses = new LinkedList<>();

    public static void addResponse(Response response) {
        if (responses.size() >= 3) {
            responses.removeFirst();
        }
        responses.addLast(response);
    }

    public static LinkedList<Response> getResponses() {
        return responses;
    }

    public static void setResponses(LinkedList<Response> responsesList) {
        responses = responsesList;
    }

    public static Response getLastResponse() {
        return responses.getLast();
    }
}
