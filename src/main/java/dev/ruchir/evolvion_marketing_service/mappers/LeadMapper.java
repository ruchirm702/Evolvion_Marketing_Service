package dev.ruchir.evolvion_marketing_service.mappers;


import dev.ruchir.evolvion_marketing_service.dto.LeadDTO;
import dev.ruchir.evolvion_marketing_service.model.Core.Lead;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LeadMapper {

    LeadDTO toDTO(Lead lead);
    Lead toEntity(LeadDTO leadDTO);

    List<LeadDTO> toDTOList(List<Lead> leads);
    List<Lead> toEntityList(List<LeadDTO> leadDTOs);
}

