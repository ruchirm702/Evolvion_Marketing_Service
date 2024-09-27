package dev.ruchir.evolvion_marketing_service.mappers;

import dev.ruchir.evolvion_marketing_service.dto.CampaignMetricsDTO;
import dev.ruchir.evolvion_marketing_service.model.Core.CampaignMetrics;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface CampaignMetricsMapper {

    CampaignMetricsDTO toDTO(CampaignMetrics campaignMetrics);
    CampaignMetrics toEntity(CampaignMetricsDTO campaignMetricsDTO);

    List<CampaignMetricsDTO> toDTOList(List<CampaignMetrics> campaignMetricsList);
    List<CampaignMetrics> toEntityList(List<CampaignMetricsDTO> campaignMetricsDTOList);
}
