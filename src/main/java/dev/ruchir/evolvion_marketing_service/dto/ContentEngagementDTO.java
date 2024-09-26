package dev.ruchir.evolvion_marketing_service.dto;

import dev.ruchir.evolvion_marketing_service.model.Enums.ContentEngagementLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ContentEngagementDTO {
    private Long contentId;
    private Long leadId;
    private ContentEngagementLevel engagementLevel; // Enum
    private Date engagementDate;
}
