package dev.ruchir.evolvion_marketing_service.repository;

import dev.ruchir.evolvion_marketing_service.model.Core.Lead;
import dev.ruchir.evolvion_marketing_service.model.Enums.LeadIndustry;
import dev.ruchir.evolvion_marketing_service.model.Enums.LeadPriority;
import dev.ruchir.evolvion_marketing_service.model.Enums.LeadSource;
import dev.ruchir.evolvion_marketing_service.model.Enums.LeadStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {

    // Find leads by their status (e.g., NEW, CONTACTED, CONVERTED, etc.)
    List<Lead> findByStatus(LeadStatus status);

    // Find leads by source (e.g., SOCIAL_MEDIA, SEO, etc.)
    List<Lead> findBySource(LeadSource source);

    // Find leads by priority (e.g., HIGH, MEDIUM, LOW)
    List<Lead> findByPriority(LeadPriority priority);

    // Find leads by industry (e.g., TECHNOLOGY, FINANCE, etc.)
    List<Lead> findByIndustry(LeadIndustry industry);

    // Custom query to find leads created within a specific date range
    List<Lead> findByCreatedAtBetween(Date startDate, Date endDate);
}
