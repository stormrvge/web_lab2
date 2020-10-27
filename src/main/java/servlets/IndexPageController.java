package servlets;

import model.RequestValidator;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/lab2")
public class IndexPageController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = request.getServletContext();
        servletContext.setAttribute("execStart", System.nanoTime());

        boolean isRequestValid = RequestValidator.validate(request);
        servletContext.setAttribute("isRequestValid", isRequestValid);


        if (isRequestValid) {
            if (request.getParameter("pic") != null && request.getParameter("pic").equals("true"))
                request.getRequestDispatcher("/imageServlet").forward(request, response);
            else
                request.getRequestDispatcher("/mainTable").forward(request, response);
        }
        else
            request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("clearTable") != null && request.getParameter("clearTable").equals("true")) {
            request.getRequestDispatcher("/tableServlet").forward(request, response);
        } else {
            request.getRequestDispatcher("/mainTable").forward(request, response);
        }

    }
}