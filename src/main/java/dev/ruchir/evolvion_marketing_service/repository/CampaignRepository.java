package dev.ruchir.evolvion_marketing_service.repository;

import dev.ruchir.evolvion_marketing_service.model.Core.Campaign;
import dev.ruchir.evolvion_marketing_service.model.Enums.CampaignObjective;
import dev.ruchir.evolvion_marketing_service.model.Enums.CampaignType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long> {

    // Find campaigns by type (e.g., EMAIL, SOCIAL_MEDIA, PPC, etc.)
    List<Campaign> findByType(CampaignType type);

    // Find campaigns by objective (e.g., LEAD_GENERATION, BRAND_AWARENESS)
    List<Campaign> findByObjective(CampaignObjective objective);

    // Custom query to find campaigns based on the start and end date
    List<Campaign> findByStartDateBetween(Date startDate, Date endDate);
}
