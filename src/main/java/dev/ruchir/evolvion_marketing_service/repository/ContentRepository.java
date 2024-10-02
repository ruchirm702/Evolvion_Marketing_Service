package dev.ruchir.evolvion_marketing_service.repository;

import dev.ruchir.evolvion_marketing_service.model.Core.Content;
import dev.ruchir.evolvion_marketing_service.model.Enums.ContentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {

    // Find content by title
    Optional<Content> findByTitle(String title);

    // Find all content by content type (e.g., BLOG, VIDEO, WEBINAR)
    List<Content> findAllByType(ContentType type);

    // Find content based on a partial match of description
    List<Content> findByDescriptionContaining(String keyword);

    // Find all content created after a specific date
    List<Content> findAllByCreatedAtAfter(Date date);

    // Find content by URL
    Optional<Content> findByUrl(String url);
}
