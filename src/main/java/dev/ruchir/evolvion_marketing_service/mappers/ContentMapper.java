package dev.ruchir.evolvion_marketing_service.mappers;

import dev.ruchir.evolvion_marketing_service.dto.ContentDTO;
import dev.ruchir.evolvion_marketing_service.model.Core.Content;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContentMapper {

    ContentDTO toDTO(Content content);
    Content toEntity(ContentDTO contentDTO);

    List<ContentDTO> toDTOList(List<Content> contents);
    List<Content> toEntityList(List<ContentDTO> contentDTOs);
}
