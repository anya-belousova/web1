package ru.laba1;

public class RequestHandler{
    public void handle() {
       FCGIRequests fcgiRequests = new FCGIRequests();
       fcgiRequests.handle();
    }
}