package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Response {
    private int x;
    private int y;
    private int r;

    private String response;
    private final String date;
    private long execTime;



    public Response(String[] x, String[] y, String[] r, long startExec) throws NumberFormatException {
        this.x = (int) (Math.random() * 6);                         //fix
        this.y = Integer.parseInt(y[0]);
        this.r = Integer.parseInt(r[0]);
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        this.date = dateFormat.format(new Date().getTime());
        validate();
        this.execTime = (System.nanoTime() - startExec) / 1000;     // мкс
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public String getHit() {
        return response;
    }

    public void setHit(String response) {
        this.response = response;
    }

    public void setExecTime(long execTime) {
        this.execTime = execTime;
    }

    public long getExecTime() {
        return execTime;
    }

    public String getDate() {
        return date;
    }

    public void validate() {
        String success = "Попал";
        String invalid = "Не попал";

        if (x > 0 && x <= r/2 && y > 0 && y <= r) {
            response = success;
            return;
        }
        else if (x > 0 && y < 0 && x <= ((y + r) / 2) && y >= (2 * x - r)) {
            response = success;
            return;
        }
        else if (x < 0 && y > 0 && (x * x + y * y) <= ((r * r) / 4)) {
            response = success;
        }
        else response = invalid;
    }
}
