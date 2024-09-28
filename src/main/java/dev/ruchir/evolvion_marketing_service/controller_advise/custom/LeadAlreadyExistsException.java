package dev.ruchir.evolvion_marketing_service.controller_advise.custom;

public class LeadAlreadyExistsException extends RuntimeException {
    public LeadAlreadyExistsException(String message) {
        super(message);
    }
}
