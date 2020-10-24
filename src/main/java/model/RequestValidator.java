package model;

import javax.servlet.http.HttpServletRequest;

public class RequestValidator {
    private HttpServletRequest request;

    public RequestValidator(HttpServletRequest request) {
        this.request = request;
    }

    public boolean validate(HttpServletRequest request) {
        return true;
    }
}
