package dev.ruchir.evolvion_marketing_service.dto;

import dev.ruchir.evolvion_marketing_service.model.Enums.LeadActivityType;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class LeadActivityDTO {

    private Long id;
    private Long leadId;
    private LeadActivityType activityType; // Enum
    private String description;
    private Date activityDate;
}
