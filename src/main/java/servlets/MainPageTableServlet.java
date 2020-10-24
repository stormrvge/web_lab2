package servlets;

import model.AreaValidator;
import model.Request;
import model.Table;

import javax.servlet.ServletContext;
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

@WebServlet("/mainTable")
public class MainPageTableServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("MainPageTableServlet init");
        addRequest(request);

        String answer = Table.getShortRequestString();
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(answer.getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
        outputStream.close();
    }

    static void addRequest(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ServletContext servletContext = request.getServletContext();
        long execStart = System.nanoTime();
        servletContext.setAttribute("execStart", execStart);

        if (session.getAttribute("requests") != null) {
            Table.setRequests((LinkedList<Request>) session.getAttribute("requests"));
        }

        Request tableRequest;
        Map<String, String[]> responseMap = request.getParameterMap();
        if ((responseMap.containsKey("x") && responseMap.containsKey("y") && responseMap.containsKey("r"))) {
            try {
                tableRequest = new Request(responseMap.get("x"), responseMap.get("y"),
                        responseMap.get("r"), execStart);
                AreaValidator.validateArea(tableRequest);
                tableRequest.setExecTime();
                Table.addResponse(tableRequest);
            } catch (NullPointerException | NumberFormatException e) {
                System.err.println("Get request with null properties.");
            }
        }

        if (servletContext.getAttribute("UrlGetRequest") != null) {
            Request getRequest = (Request) servletContext.getAttribute("UrlGetRequest");
            AreaValidator.validateArea(getRequest);
            getRequest.setStartExec(execStart);
            getRequest.setExecTime();
            Table.addResponse(getRequest);

            servletContext.setAttribute("UrlGetRequest", null);
        }

        session.setAttribute("requests", Table.getRequests());
    }
}