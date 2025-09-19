package ru.laba1.validation;

import ru.laba1.Coordinates;

public class CheckArea {
    public boolean validate(Coordinates coordinates) {
        double x = coordinates.x(), y = coordinates.y(), r = coordinates.r();
        return (x >= 0 && y >= 0 && y <= -0.5 * x+r/2) || ((y <= 0) && (x <= 0) && (y >= -r) && (x >= -r/2)) || ((x <= 0) && (y >= 0) && (x * x + y * y <= r*r/4));
    }
}
