package dev.ruchir.evolvion_marketing_service.services.Implementations;

import dev.ruchir.evolvion_marketing_service.dto.ContentDTO;
import dev.ruchir.evolvion_marketing_service.mappers.ContentMapper;
import dev.ruchir.evolvion_marketing_service.model.Core.Content;
import dev.ruchir.evolvion_marketing_service.model.Enums.ContentType;
import dev.ruchir.evolvion_marketing_service.repository.ContentRepository;
import dev.ruchir.evolvion_marketing_service.services.Interfaces.ContentService;
import dev.ruchir.evolvion_marketing_service.controller_advise.custom.ContentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ContentServiceImpl implements ContentService {

    private final ContentRepository contentRepository;
    private final ContentMapper contentMapper;

    @Autowired
    public ContentServiceImpl(ContentRepository contentRepository, ContentMapper contentMapper) {
        this.contentRepository = contentRepository;
        this.contentMapper = contentMapper;
    }

    @Override
    public ContentDTO createContent(ContentDTO contentDTO) {
        Content content = contentMapper.toEntity(contentDTO);
        content = contentRepository.save(content);
        return contentMapper.toDTO(content);
    }

    @Override
    public ContentDTO updateContent(Long contentId, ContentDTO contentDTO) {
        Content existingContent = contentRepository.findById(contentId)
                .orElseThrow(() -> new ContentNotFoundException("Content with ID " + contentId + " not found"));

        contentMapper.updateEntityFromDTO(contentDTO, existingContent);  // Assuming you have a method to update the entity
        existingContent = contentRepository.save(existingContent);
        return contentMapper.toDTO(existingContent);
    }

    @Override
    public void deleteContent(Long contentId) {
        if (!contentRepository.existsById(contentId)) {
            throw new ContentNotFoundException("Content with ID " + contentId + " not found");
        }
        contentRepository.deleteById(contentId);
    }

    @Override
    public ContentDTO getContentById(Long contentId) {
        Content content = contentRepository.findById(contentId)
                .orElseThrow(() -> new ContentNotFoundException("Content with ID " + contentId + " not found"));
        return contentMapper.toDTO(content);
    }

    @Override
    public List<ContentDTO> getAllContent() {
        List<Content> contents = contentRepository.findAll();
        return contentMapper.toDTOList(contents);
    }

    @Override
    public ContentDTO getContentByTitle(String title) {
        Optional<Content> content = contentRepository.findByTitle(title);
        return content.map(contentMapper::toDTO)
                .orElseThrow(() -> new ContentNotFoundException("Content with title " + title + " not found"));
    }

    @Override
    public List<ContentDTO> getContentByType(ContentType type) {
        List<Content> contents = contentRepository.findByType(type);
        return contentMapper.toDTOList(contents);
    }

    @Override
    public List<ContentDTO> searchContentByDescription(String keyword) {
        List<Content> contents = contentRepository.findByDescriptionContaining(keyword);
        return contentMapper.toDTOList(contents);
    }

    @Override
    public List<ContentDTO> getContentCreatedAfter(Date date) {
        List<Content> contents = contentRepository.findByCreatedAtAfter(date);
        return contentMapper.toDTOList(contents);
    }

    @Override
    public ContentDTO getContentByUrl(String url) {
        Optional<Content> content = contentRepository.findByUrl(url);
        return content.map(contentMapper::toDTO)
                .orElseThrow(() -> new ContentNotFoundException("Content with URL " + url + " not found"));
    }
}
