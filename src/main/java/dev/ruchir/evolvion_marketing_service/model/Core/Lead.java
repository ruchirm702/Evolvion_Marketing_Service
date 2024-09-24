package dev.ruchir.evolvion_marketing_service.model.Core;

import dev.ruchir.evolvion_marketing_service.model.Enums.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "leads")

public class Lead extends BaseModel {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private LeadStatus status;

    @Enumerated(EnumType.STRING)
    private LeadSource source;

    @Enumerated(EnumType.STRING)
    private LeadPriority priority;

    @Enumerated(EnumType.STRING)
    private LeadQualification qualification;

    @Enumerated(EnumType.STRING)
    private LeadIndustry industry;

    @Enumerated(EnumType.STRING)
    private LeadEngagementLevel engagementLevel;

    @Enumerated(EnumType.STRING)
    private LeadStage stage;
}