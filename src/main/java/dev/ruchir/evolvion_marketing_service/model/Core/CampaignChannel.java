package dev.ruchir.evolvion_marketing_service.model.Core;

import dev.ruchir.evolvion_marketing_service.model.Enums.ChannelType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "campaign_channels")

public class CampaignChannel extends BaseModel {
    @ManyToOne
    @JoinColumn(name = "campaign_id")
    private Campaign campaign;

    @Enumerated(EnumType.STRING)
    private ChannelType channelType;

    private Double budget;
    private Long impressions;
    private Long clicks;
}
