package servlets;

import model.Table;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

@WebServlet("/tableServlet")
public class TablePageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        MainPageTableServlet.addRequest(request);

        String answer = Table.getRequestString();
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(answer.getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
        outputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        if (request.getParameter("clearTable") != null && request.getParameter("clearTable").equals("true"))
            Table.clearTable();
    }
}
