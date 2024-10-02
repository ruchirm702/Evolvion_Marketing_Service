package dev.ruchir.evolvion_marketing_service.services.Interfaces;

import dev.ruchir.evolvion_marketing_service.dto.ContentDTO;
import dev.ruchir.evolvion_marketing_service.model.Enums.ContentType;

import java.util.Date;
import java.util.List;

public interface ContentService {

    // Create new content
    ContentDTO createContent(ContentDTO contentDTO);

    // Update existing content
    ContentDTO updateContent(Long contentId, ContentDTO contentDTO);

    // Delete content by ID
    void deleteContent(Long contentId);

    // Retrieve content by ID
    ContentDTO getContentById(Long contentId);

    // Retrieve all content
    List<ContentDTO> getAllContent();

    // Retrieve content by title
    ContentDTO getContentByTitle(String title);

    // Retrieve content by content type (e.g., BLOG, VIDEO, etc.)
    List<ContentDTO> getContentByType(ContentType type);

    // Search content by keyword in description
    List<ContentDTO> searchContentByDescription(String keyword);

    // Retrieve content created after a specific date
    List<ContentDTO> getContentCreatedAfter(Date date);

    // Retrieve content by URL
    ContentDTO getContentByUrl(String url);
}
