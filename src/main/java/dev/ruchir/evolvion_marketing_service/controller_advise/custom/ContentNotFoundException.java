package dev.ruchir.evolvion_marketing_service.controller_advise.custom;

public class ContentNotFoundException extends RuntimeException {
    public ContentNotFoundException(String message) {
        super(message);
    }
}