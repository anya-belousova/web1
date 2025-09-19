package ru.laba1.process;

public class Content {
    String content = """
                        <td>%s</td>
                        <td>%d</td>
                        """;
    public String returnContent(String result, double allTime){
        return content.formatted(result, allTime);

    }
}
