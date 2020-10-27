package servlets;

import model.AreaValidator;
import model.Table;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class ImageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        MainPageTableServlet.addRequest(request);
        String hit = Table.getLastRequest().getHit().equals(AreaValidator.success) ? "true" : "false";

        OutputStream outputStream = response.getOutputStream();
        outputStream.write((Table.getShortRequestString() + "ENDOFTABLE\n" + hit).getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
        outputStream.close();
    }
}
