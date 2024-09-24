package dev.ruchir.evolvion_marketing_service.model.Core;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "campaign_metrics")
public class CampaignMetrics extends BaseModel {

    @ManyToOne
    @JoinColumn(name = "campaign_id")
    private Campaign campaign;

    private Long impressions;
    private Long clicks;
    private Long conversions;
    private Double engagementRate;
}
