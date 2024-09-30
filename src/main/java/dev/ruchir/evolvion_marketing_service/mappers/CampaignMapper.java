package dev.ruchir.evolvion_marketing_service.mappers;

import dev.ruchir.evolvion_marketing_service.dto.CampaignDTO;
import dev.ruchir.evolvion_marketing_service.model.Core.Campaign;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CampaignMapper {

    CampaignDTO toDTO(Campaign campaign);

    Campaign toEntity(CampaignDTO campaignDTO);

    List<CampaignDTO> toDTOList(List<Campaign> campaigns);

    List<Campaign> toEntityList(List<CampaignDTO> campaignDTOs);

    // Add the updateEntityFromDTO method
    void updateEntityFromDTO(CampaignDTO campaignDTO, @MappingTarget Campaign campaign);
}
