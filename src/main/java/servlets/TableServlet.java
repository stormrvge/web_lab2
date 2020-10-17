package servlets;

import model.Response;
import model.Table;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.Map;

@WebServlet("/table")
public class TableServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ServletContext servletContext = request.getServletContext();
        long execStart = System.nanoTime();
        servletContext.setAttribute("execStart", execStart);

        if (session.getAttribute("responses") != null) {
            Table.setResponses((LinkedList<Response>) session.getAttribute("responses"));
        }

        Response tableResponse;
        Map<String, String[]> responseMap = request.getParameterMap();
        if (responseMap.containsKey("y") && responseMap.containsKey("r")) {
            try {
                tableResponse = new Response(responseMap.get("y"), responseMap.get("y"),    //CHANGE X TO Y
                        responseMap.get("r"), execStart);
                Table.addResponse(tableResponse);
            } catch (NullPointerException | NumberFormatException e) {
                System.err.println("Get request with null properties.");
            }
        }

        session.setAttribute("responses", Table.getResponses());

        StringBuilder ans = new StringBuilder();
        LinkedList<Response> responses = Table.getResponses();
        for (Response resp : responses) {
            ans.append("<tr>" + "<td>").append(resp.getX()).append("</td>")
                    .append("<td>").append(resp.getY()).append("</td>")
                    .append("<td>").append(resp.getR()).append("</td>")
                    .append("<td>").append(resp.getHit()).append("</td>").append("<td>")
                    .append(resp.getDate()).append("</td>").append("<td>").append(resp.getExecTime())
                    .append("</td> </tr>");
        }

        String answer = ans.toString();
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(answer.getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
        outputStream.close();
    }
}