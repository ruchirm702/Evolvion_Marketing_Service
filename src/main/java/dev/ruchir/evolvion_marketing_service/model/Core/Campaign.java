package dev.ruchir.evolvion_marketing_service.model.Core;

import dev.ruchir.evolvion_marketing_service.model.Enums.CampaignObjective;
import dev.ruchir.evolvion_marketing_service.model.Enums.CampaignType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "campaigns")
public class Campaign extends BaseModel {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Primary key

    // Add campaignId field
    private UUID campaignId;

    private String name;

    @Enumerated(EnumType.STRING)
    private CampaignType type;

    @Enumerated(EnumType.STRING)
    private CampaignObjective objective;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;

    private Double budget;

    private String targetAudience;


}
