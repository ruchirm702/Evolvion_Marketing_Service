package dev.ruchir.evolvion_marketing_service.model.Core;

import dev.ruchir.evolvion_marketing_service.model.Enums.CampaignType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "campaigns")
public class Campaign extends BaseModel {

    private String name;

    @Enumerated(EnumType.STRING)
    private CampaignType type;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;

    private Double budget;

    private String targetAudience;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "campaign")
    private List<CampaignMetrics> performanceMetrics;
}
