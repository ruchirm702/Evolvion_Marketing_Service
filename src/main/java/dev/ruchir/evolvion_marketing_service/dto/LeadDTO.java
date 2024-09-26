package dev.ruchir.evolvion_marketing_service.dto;

import dev.ruchir.evolvion_marketing_service.model.Enums.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class LeadDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LeadStatus status; // Enum
    private LeadSource source; // Enum
    private LeadPriority priority; // Enum
    private LeadQualification qualification; // Enum
    private LeadIndustry industry; // Enum
    private LeadEngagementLevel engagementLevel; // Enum
    private LeadStage stage; // Enum
    private Date createdAt;
    private Date updatedAt;
}
