package dev.ruchir.evolvion_marketing_service.dto;

import dev.ruchir.evolvion_marketing_service.model.Enums.CampaignObjective;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CampaignObjectiveDTO {
    private CampaignObjective objective; // Enum
    private String description; // Optional description of the objective
}
