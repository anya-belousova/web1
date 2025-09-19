package ru.laba1.process;

import java.nio.charset.StandardCharsets;

public class PrintError {
    public static void error(String message) {
        message = message.replace("\n", " ");

        String content = """
                {
                    "error": "%s"
                }
                """.formatted(message);


        var response = """
                HTTP/2 400 Bad Request
                Content-Type: application/json
                Content-Length: %d
                
                %s
                
                """.formatted(content.getBytes(StandardCharsets.UTF_8).length, content);

        System.out.println(response);
    }
}
