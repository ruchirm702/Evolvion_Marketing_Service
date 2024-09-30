package dev.ruchir.evolvion_marketing_service.controller_advise.custom;

public class CampaignNotFoundException extends RuntimeException {
    public CampaignNotFoundException(String message) {
        super(message);
    }
}