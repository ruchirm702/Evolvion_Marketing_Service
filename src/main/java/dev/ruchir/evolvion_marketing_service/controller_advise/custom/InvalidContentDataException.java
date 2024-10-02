package dev.ruchir.evolvion_marketing_service.controller_advise.custom;

public class InvalidContentDataException extends RuntimeException {
    public InvalidContentDataException(String message) {
        super(message);
    }
}