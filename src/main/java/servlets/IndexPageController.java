package servlets;

import model.Request;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/test")
public class IndexPageController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("IndexPageController init");

        if (request.getParameter("x") != null && request.getParameter("y") != null && request.getParameter("r") != null) {
            String[] x = {request.getParameter("x")};
            String[] y = {request.getParameter("y")};
            String[] r = {request.getParameter("r")};
            Request getRequest = new Request(x, y, r, 0);
            ServletContext servletContext = request.getServletContext();
            servletContext.setAttribute("UrlGetRequest", getRequest);
        }

        request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
    }
}