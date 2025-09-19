package ru.laba1.reading;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.laba1.Coordinates;

import java.io.IOException;

public class CoordinatesReader {
    public static double allTime;
    public Coordinates read() throws IOException {
        double start = System.nanoTime();
        ObjectMapper objectMapper = new ObjectMapper();
        Reader reader = new Reader();
        Coordinates coordinates = objectMapper.readValue(reader.read(), Coordinates.class);
        allTime = System.nanoTime() - start;
        return coordinates;
    }
}
