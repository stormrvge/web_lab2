package model;

public class Response {
    private int x;
    private int y;
    private int r;

    private String response;

    public Response(String[] x, String[] y, String[] r) {
        this.x = 5;
        this.y = Integer.parseInt(y[0]);
        this.r = Integer.parseInt(r[0]);
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

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String validate() {
        return "No hit";
    }
}
