package ru.laba1.process;

import java.nio.charset.StandardCharsets;

public class Response {
    public String returnResponse(String result, double allTime) {
        Content content = new Content();
        String cont = content.returnContent(result, allTime);
        String response = """
                HTTP/2 200 OK
                Content-Type: text/html
                Content-Length: %d
                                        
                %s
                                        
                """.formatted(cont.getBytes(StandardCharsets.UTF_8).length, cont);
        return response;
    }
}
