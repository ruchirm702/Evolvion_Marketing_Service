package dev.ruchir.evolvion_marketing_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CampaignMetricsDTO {

    private Long id;
    private Long campaignId;
    private Long impressions;
    private Long clicks;
    private Long conversions;
    private Double engagementRate;
}
