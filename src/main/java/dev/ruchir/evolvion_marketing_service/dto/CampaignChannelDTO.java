package dev.ruchir.evolvion_marketing_service.dto;

import dev.ruchir.evolvion_marketing_service.model.Enums.ChannelType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CampaignChannelDTO {

    private Long id;
    private Long campaignId;
    private ChannelType channelType; // Enum
    private Double budget;
    private Long impressions;
    private Long clicks;
}
