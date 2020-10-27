package model;

import javax.servlet.http.HttpServletRequest;

public class RequestValidator {

    public static boolean validate(HttpServletRequest request) {
        try {
            Double x = Double.parseDouble(request.getParameter("x"));
            Double y = Double.parseDouble(request.getParameter("y"));
            Double r = Double.parseDouble(request.getParameter("r"));
            boolean isXValid = false;
            boolean isYValid = false;
            boolean isRValid = false;

            if (x == -2 || x == -1.5 || x == -1.0 || x == -0.5 || x == 0 ||
                    x == 0.5 || x == 1.0 || x == 1.5 || x == 2.0) {
                isXValid = true;
            }
            if (y.compareTo(-3.0) > 0 && y.compareTo(5.0) < 0) {
                isYValid = true;
            }
            if (r.compareTo(1.0) >= 0 && r.compareTo(4.0) <= 0) {
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
