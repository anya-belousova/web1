package ru.laba1.validation;

import ru.laba1.Coordinates;

public class ValidateCoordinates {
    private double[] listX = {-2.0, -1.5, -1.0, -0.5, 0.0, 0.5, 1.0, 1.5, 2.0};
    private double[] listR = {1.0, 2.0, 3.0, 4.0, 5.0};

    public boolean validate(Coordinates coordinates) {
        double x = coordinates.x();
        double y = coordinates.y();
        double r = coordinates.r();

        if (!(y > -3 && y < 5)) {
            return false;
        }

        boolean xIsValid = false;
        for (double validX : listX) {
            if (Double.compare(x, validX) == 0) {
                xIsValid = true;
                break;
            }
        }
        if (!xIsValid) {
            return false;
        }

        boolean rIsValid = false;
        for (double validR : listR) {
            if (Double.compare(r, validR) == 0) {
                rIsValid = true;
                break;
            }
        }
        if (!rIsValid) {
            return false;
        }

        return true;
    }
}



