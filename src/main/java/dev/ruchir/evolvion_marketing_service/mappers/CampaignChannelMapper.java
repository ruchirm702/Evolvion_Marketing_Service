package dev.ruchir.evolvion_marketing_service.mappers;

import dev.ruchir.evolvion_marketing_service.dto.CampaignChannelDTO;
import dev.ruchir.evolvion_marketing_service.model.Core.CampaignChannel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CampaignChannelMapper {

    CampaignChannelDTO toDTO(CampaignChannel campaignChannel);
    CampaignChannel toEntity(CampaignChannelDTO campaignChannelDTO);

    List<CampaignChannelDTO> toDTOList(List<CampaignChannel> campaignChannels);
    List<CampaignChannel> toEntityList(List<CampaignChannelDTO> campaignChannelDTOs);
}
