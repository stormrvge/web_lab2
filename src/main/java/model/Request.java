package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Request {
    private float x;
    private float y;
    private float r;

    private String isHit;
    private final String date;
    private long startExec;
    private long execTime;



    public Request(String[] x, String[] y, String[] r, long startExec) throws NumberFormatException {
        this.x = Float.parseFloat(x[0]);
        this.y = Float.parseFloat(y[0]);
        this.r = Float.parseFloat(r[0]);
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        this.date = dateFormat.format(new Date().getTime());
        this.startExec = startExec;
    }

    public float getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public float getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public String getHit() {
        return isHit;
    }

    public void setHit(String isHit) {
        this.isHit = isHit;
    }

    public long getExecTime() {
        return execTime;
    }

    public void setExecTime() {
        execTime = (System.nanoTime() - startExec) / 1000;
    }

    public void setStartExec(long startExec) {
        this.startExec = startExec;
    }

    public String getDate() {
        return date;
    }
}
