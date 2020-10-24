package model;

import java.util.LinkedList;

public class Table {
    private static LinkedList<Request> requests = new LinkedList<>();

    public static void addResponse(Request response) {
        requests.addLast(response);
    }

    public static String getRequestString() {
        StringBuilder ans = new StringBuilder();

        for (Request request : requests) {
            toHtmlTable(ans, request);
        }

        return ans.toString();
    }

    public static String getShortRequestString() {
        StringBuilder ans = new StringBuilder();

        int i = 3;  // short request should contain 3 elements
        int k = 0;

        if (requests.size() < 3)
            i = requests.size();

        for (; i > 0; i--) {
            Request request;
            if (requests.size() > 3)
                request = requests.get(requests.size() - i);
            else
                request = requests.get(k++);
            toHtmlTable(ans, request);
        }
        return ans.toString();
    }

    private static void toHtmlTable(StringBuilder ans, Request request) {
        ans.append("<tr>" + "<td>").append(request.getX()).append("</td>")
                .append("<td>").append(request.getY()).append("</td>")
                .append("<td>").append(request.getR()).append("</td>")
                .append("<td>").append(request.getHit()).append("</td>").append("<td>")
                .append(request.getDate()).append("</td>").append("<td>").append(request.getExecTime())
                .append("</td> </tr>");
    }

    public static LinkedList<Request> getRequests() {
        return requests;
    }

    public static void setRequests(LinkedList<Request> requestsList) {
        requests = requestsList;
    }
}
