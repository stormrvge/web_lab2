package servlets;

import model.AreaValidator;
import model.Request;
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

@WebServlet("/mainTable")
public class MainPageTableServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("MainPageTableServlet init");
        boolean isRequestValid = (boolean) request.getServletContext().getAttribute("isRequestValid");

        if (isRequestValid)
            addRequest(request);

        if ((request.getParameter("form") != null  || request.getParameter("pic") != null)) {
            String answer = Table.getShortRequestString();
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(answer.getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
            outputStream.close();
        } else if (!isRequestValid) {
            OutputStream outputStream = response.getOutputStream();
            outputStream.write("Не входит в множество".getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
            outputStream.close();
        }
        else {
            request.getRequestDispatcher("jsp/index.jsp").forward(request, response);   // dont need ajax on url request
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String answer = Table.getShortRequestString();
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(answer.getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
        outputStream.close();
    }

    static void addRequest(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ServletContext servletContext = request.getServletContext();
        long execStart = (long) servletContext.getAttribute("execStart");

        if (session.getAttribute("requests") != null) {
            Table.setRequests((LinkedList<Request>) session.getAttribute("requests"));
        }

        Request tableRequest;
        Map<String, String[]> responseMap = request.getParameterMap();
        if ((responseMap.containsKey("x") && responseMap.containsKey("y") && responseMap.containsKey("r"))) {
            try {
                tableRequest = new Request(responseMap.get("x"), responseMap.get("y"), responseMap.get("r"), execStart);
                AreaValidator.validateArea(tableRequest);
                tableRequest.setExecTime();

                Table.addResponse(tableRequest);
            } catch (NullPointerException | NumberFormatException e) {
                System.err.println("Get request with null properties.");
            }
        }

        session.setAttribute("requests", Table.getRequests());
    }
}