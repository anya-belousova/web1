package ru.laba1.validation;

import ru.laba1.process.PrintError;
import ru.laba1.reading.CoordinatesReader;

import java.io.IOException;

public class ValidateService{
    private final CheckArea checkArea = new CheckArea();
    private final ValidateCoordinates validateCoordinates = new ValidateCoordinates();
    CoordinatesReader coordinates = new CoordinatesReader();
    public String validate() throws IOException {
        if (!validateCoordinates.validate(coordinates.read())) {
            PrintError.error("Данные не валидны");
        }
        String result = checkArea.validate(coordinates.read()) ? "true" : "false";
        return result;
    }
}
