package servlets;

import model.Response;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class AreaCheckServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String[]> responseMap = request.getParameterMap();
        Response responseValidate = null;
        try {
            responseValidate = new Response(responseMap.get("x"), responseMap.get("y"), responseMap.get("r"));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        String answer = "";
        if (responseValidate != null) {
            answer = responseValidate.validate();
        }
    }
}