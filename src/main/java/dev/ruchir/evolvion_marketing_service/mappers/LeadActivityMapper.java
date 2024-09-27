package dev.ruchir.evolvion_marketing_service.mappers;

import dev.ruchir.evolvion_marketing_service.dto.LeadActivityDTO;
import dev.ruchir.evolvion_marketing_service.model.Core.LeadActivity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LeadActivityMapper {

    LeadActivityDTO toDTO(LeadActivity leadActivity);
    LeadActivity toEntity(LeadActivityDTO leadActivityDTO);

    List<LeadActivityDTO> toDTOList(List<LeadActivity> leadActivities);
    List<LeadActivity> toEntityList(List<LeadActivityDTO> leadActivityDTOs);
}
