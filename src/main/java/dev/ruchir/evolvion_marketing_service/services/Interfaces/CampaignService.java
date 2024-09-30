package dev.ruchir.evolvion_marketing_service.services.Interfaces;

import dev.ruchir.evolvion_marketing_service.dto.CampaignDTO;
import dev.ruchir.evolvion_marketing_service.model.Enums.CampaignObjective;
import dev.ruchir.evolvion_marketing_service.model.Enums.CampaignType;

import java.util.Date;
import java.util.List;

public interface CampaignService {

    CampaignDTO createCampaign(CampaignDTO campaignDTO);
    CampaignDTO updateCampaign(Long campaignId, CampaignDTO campaignDTO);
    void deleteCampaign(Long campaignId);
    CampaignDTO getCampaignById(Long campaignId);
    List<CampaignDTO> getAllCampaigns();
    List<CampaignDTO> getCampaignsByType(CampaignType type);
    List<CampaignDTO> getCampaignsByObjective(CampaignObjective objective);
    List<CampaignDTO> getCampaignsByDateRange(Date startDate, Date endDate);
    void scheduleCampaign(Long campaignId);
    void trackCampaignMetrics(Long campaignId);
    void segmentLeads(Long campaignId);
    void automateCampaign(Long campaignId);
    CampaignDTO analyzeCampaign(Long campaignId);
}
