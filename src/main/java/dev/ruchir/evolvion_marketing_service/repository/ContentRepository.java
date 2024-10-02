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

    // Find content by URL
    Optional<Content> findByUrl(String url);

    // Find content by type
    List<Content> findByType(ContentType type);

    // Find content by creation date
    List<Content> findByCreatedAtAfter(Date date);

    // Find content by description containing a keyword
    List<Content> findByDescriptionContaining(String keyword);
}
