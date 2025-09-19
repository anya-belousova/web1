package ru.laba1.reading;

import java.io.IOException;

public class Reader {
    public String read() throws IOException {
        ReadRequest reader = new ReadRequest();
        String requestBody = reader.readRequestBody();
        return requestBody;
    }
}
