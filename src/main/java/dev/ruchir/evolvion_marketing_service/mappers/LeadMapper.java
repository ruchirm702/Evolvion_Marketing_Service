package dev.ruchir.evolvion_marketing_service.mappers;

import dev.ruchir.evolvion_marketing_service.dto.LeadDTO;
import dev.ruchir.evolvion_marketing_service.model.Core.Lead;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LeadMapper {

    // Convert Lead entity to LeadDTO
    LeadDTO toDTO(Lead lead);

    // Convert LeadDTO to Lead entity
    Lead toEntity(LeadDTO leadDTO);

    // Convert list of Lead entities to list of LeadDTOs
    List<LeadDTO> toDTOList(List<Lead> leads);

    // Convert list of LeadDTOs to list of Lead entities
    List<Lead> toEntityList(List<LeadDTO> leadDTOs);

    // Update existing Lead entity from LeadDTO
    void updateEntityFromDTO(LeadDTO leadDTO, @MappingTarget Lead lead);
}
