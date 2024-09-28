package dev.ruchir.evolvion_marketing_service.controller_advise.custom;

public class LeadNotFoundException extends RuntimeException {
    public LeadNotFoundException(String message) {
        super(message);
    }
}
