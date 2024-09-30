package dev.ruchir.evolvion_marketing_service.controller_advise.custom;

public class CampaignAlreadyExistsException extends RuntimeException {
    public CampaignAlreadyExistsException(String message) {
        super(message);
    }
}