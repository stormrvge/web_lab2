package model;

public class AreaValidator {
    public static final String success = "Попал";
    public static final String invalid = "Не попал";

    public static void validateArea(Request request) {


        float x = request.getX();
        float y = request.getY();
        float r = request.getR();

        if (x > 0 && x <= r/2.0 && y > 0 && y <= r) {
            request.setHit(success);
        }
        else if (x > 0 && y < 0 && x <= ((y + r) / 2.0) && y >= (2 * x - r)) {
            request.setHit(success);
        }
        else if (x < 0 && y > 0 && (x * x + y * y) <= ((r * r) / 4.0)) {
            request.setHit(success);
        }
        else
            request.setHit(invalid);
    }
}
