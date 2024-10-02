package dev.ruchir.evolvion_marketing_service.controller_advise.custom;

public class ContentAlreadyExistsException extends RuntimeException {
    public ContentAlreadyExistsException(String message) {
        super(message);
    }
}