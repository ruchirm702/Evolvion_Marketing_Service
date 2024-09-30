package dev.ruchir.evolvion_marketing_service.services.Implementations;

import dev.ruchir.evolvion_marketing_service.dto.CampaignDTO;
import dev.ruchir.evolvion_marketing_service.mappers.CampaignMapper;
import dev.ruchir.evolvion_marketing_service.model.Core.Campaign;
import dev.ruchir.evolvion_marketing_service.model.Enums.CampaignObjective;
import dev.ruchir.evolvion_marketing_service.model.Enums.CampaignType;
import dev.ruchir.evolvion_marketing_service.repository.CampaignRepository;
import dev.ruchir.evolvion_marketing_service.services.Interfaces.CampaignService;
import dev.ruchir.evolvion_marketing_service.controller_advise.custom.CampaignNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CampaignServiceImpl implements CampaignService {

    private final CampaignRepository campaignRepository;
    private final CampaignMapper campaignMapper;

    @Autowired
    public CampaignServiceImpl(CampaignRepository campaignRepository, CampaignMapper campaignMapper) {
        this.campaignRepository = campaignRepository;
        this.campaignMapper = campaignMapper;
    }

    @Override
    public CampaignDTO createCampaign(CampaignDTO campaignDTO) {
        Campaign campaign = campaignMapper.toEntity(campaignDTO);
        campaign.setCampaignId(UUID.randomUUID());  // Set unique campaign identifier
        campaign = campaignRepository.save(campaign);
        return campaignMapper.toDTO(campaign);
    }

    @Override
    public CampaignDTO updateCampaign(Long campaignId, CampaignDTO campaignDTO) {
        Campaign existingCampaign = campaignRepository.findById(campaignId)
                .orElseThrow(() -> new CampaignNotFoundException("Campaign with ID " + campaignId + " not found"));

        campaignMapper.updateEntityFromDTO(campaignDTO, existingCampaign);  // Update the existing entity
        existingCampaign = campaignRepository.save(existingCampaign);
        return campaignMapper.toDTO(existingCampaign);
    }

    @Override
    public void deleteCampaign(Long campaignId) {
        if (!campaignRepository.existsById(campaignId)) {
            throw new CampaignNotFoundException("Campaign with ID " + campaignId + " not found");
        }
        campaignRepository.deleteById(campaignId);
    }

    @Override
    public CampaignDTO getCampaignById(Long campaignId) {
        Campaign campaign = campaignRepository.findById(campaignId)
                .orElseThrow(() -> new CampaignNotFoundException("Campaign with ID " + campaignId + " not found"));
        return campaignMapper.toDTO(campaign);
    }

    @Override
    public List<CampaignDTO> getAllCampaigns() {
        List<Campaign> campaigns = campaignRepository.findAll();
        return campaignMapper.toDTOList(campaigns);
    }

    @Override
    public List<CampaignDTO> getCampaignsByType(CampaignType type) {
        List<Campaign> campaigns = campaignRepository.findByType(type);
        return campaignMapper.toDTOList(campaigns);
    }

    @Override
    public List<CampaignDTO> getCampaignsByObjective(CampaignObjective objective) {
        List<Campaign> campaigns = campaignRepository.findByObjective(objective);
        return campaignMapper.toDTOList(campaigns);
    }

    @Override
    public List<CampaignDTO> getCampaignsByDateRange(Date startDate, Date endDate) {
        List<Campaign> campaigns = campaignRepository.findByStartDateBetween(startDate, endDate);
        return campaignMapper.toDTOList(campaigns);
    }

    @Override
    public void scheduleCampaign(Long campaignId) {
        Campaign campaign = campaignRepository.findById(campaignId)
                .orElseThrow(() -> new CampaignNotFoundException("Campaign with ID " + campaignId + " not found"));
        // Implementation for scheduling a campaign (e.g., using a scheduled task or job runner)
        // This could include setting a scheduled time in the campaign entity
    }

    @Override
    public void trackCampaignMetrics(Long campaignId) {
        Campaign campaign = campaignRepository.findById(campaignId)
                .orElseThrow(() -> new CampaignNotFoundException("Campaign with ID " + campaignId + " not found"));
        // Implementation for tracking campaign metrics (e.g., tracking engagement, ROI, etc.)
        // Could involve accessing other services or repositories to gather metrics
    }

    @Override
    public void segmentLeads(Long campaignId) {
        Campaign campaign = campaignRepository.findById(campaignId)
                .orElseThrow(() -> new CampaignNotFoundException("Campaign with ID " + campaignId + " not found"));
        // Implementation for segmenting leads based on engagement with the campaign
        // This may require integration with a lead management service
    }

    @Override
    public void automateCampaign(Long campaignId) {
        Campaign campaign = campaignRepository.findById(campaignId)
                .orElseThrow(() -> new CampaignNotFoundException("Campaign with ID " + campaignId + " not found"));
        // Implementation for automating campaign delivery (e.g., integrating with marketing automation tools)
        // Could involve setting up a job in a task scheduler or calling an external service
    }

    @Override
    public CampaignDTO analyzeCampaign(Long campaignId) {
        Campaign campaign = campaignRepository.findById(campaignId)
                .orElseThrow(() -> new CampaignNotFoundException("Campaign with ID " + campaignId + " not found"));
        // Implementation for analyzing the campaign's effectiveness (e.g., calculating ROI, engagement rate, etc.)
        // Return the DTO for display or further processing
        return campaignMapper.toDTO(campaign);
    }
}
