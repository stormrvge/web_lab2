package model;

import javax.servlet.http.HttpServletRequest;

public class RequestValidator {

    public static boolean validate(HttpServletRequest request) {
        try {
            float x = Float.parseFloat(request.getParameter("x"));
            float y = Float.parseFloat(request.getParameter("y"));
            float r = Float.parseFloat(request.getParameter("r"));
            boolean isXValid = false;
            boolean isYValid = false;
            boolean isRValid = false;

            if (x == -2 || x == -1.5 || x == -1.0 || x == -0.5 || x == 0 ||
                    x == 0.5 || x == 1.0 || x == 1.5 || x == 2.0) {
                isXValid = true;
            }
            if (y >= -3 && y <= 5) {
                isYValid = true;
            }
            if (r >= 1 && r <= 4) {
                isRValid = true;
            }

            if (request.getParameter("pic") != null && request.getParameter("pic").equals("true"))
                isXValid = true;

            if (request.getParameter("pic") != null && request.getParameter("pic").equals("true"))
                isXValid = true;

            return isXValid && isYValid && isRValid;
        } catch (NullPointerException | NumberFormatException e) {
            System.err.println("Request with null x, y or r");
        }
        return false;
    }
}
