package dev.ruchir.evolvion_marketing_service.controller;

import dev.ruchir.evolvion_marketing_service.dto.CampaignDTO;
import dev.ruchir.evolvion_marketing_service.model.Enums.CampaignObjective;
import dev.ruchir.evolvion_marketing_service.model.Enums.CampaignType;
import dev.ruchir.evolvion_marketing_service.services.Interfaces.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/campaigns")
public class CampaignController {

    private final CampaignService campaignService;

    @Autowired
    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @PostMapping
    public ResponseEntity<CampaignDTO> createCampaign(@RequestBody CampaignDTO campaignDTO) {
        CampaignDTO createdCampaign = campaignService.createCampaign(campaignDTO);
        return ResponseEntity.status(201).body(createdCampaign);
    }

    @PutMapping("/{campaignId}")
    public ResponseEntity<CampaignDTO> updateCampaign(@PathVariable Long campaignId, @RequestBody CampaignDTO campaignDTO) {
        CampaignDTO updatedCampaign = campaignService.updateCampaign(campaignId, campaignDTO);
        return ResponseEntity.ok(updatedCampaign);
    }

    @DeleteMapping("/{campaignId}")
    public ResponseEntity<Void> deleteCampaign(@PathVariable Long campaignId) {
        campaignService.deleteCampaign(campaignId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{campaignId}")
    public ResponseEntity<CampaignDTO> getCampaignById(@PathVariable Long campaignId) {
        CampaignDTO campaignDTO = campaignService.getCampaignById(campaignId);
        return ResponseEntity.ok(campaignDTO);
    }

    @GetMapping
    public ResponseEntity<List<CampaignDTO>> getAllCampaigns() {
        List<CampaignDTO> campaigns = campaignService.getAllCampaigns();
        return ResponseEntity.ok(campaigns);
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<CampaignDTO>> getCampaignsByType(@PathVariable CampaignType type) {
        List<CampaignDTO> campaigns = campaignService.getCampaignsByType(type);
        return ResponseEntity.ok(campaigns);
    }

    @GetMapping("/objective/{objective}")
    public ResponseEntity<List<CampaignDTO>> getCampaignsByObjective(@PathVariable CampaignObjective objective) {
        List<CampaignDTO> campaigns = campaignService.getCampaignsByObjective(objective);
        return ResponseEntity.ok(campaigns);
    }

    @GetMapping("/date-range")
    public ResponseEntity<List<CampaignDTO>> getCampaignsByDateRange(@RequestParam Date startDate, @RequestParam Date endDate) {
        List<CampaignDTO> campaigns = campaignService.getCampaignsByDateRange(startDate, endDate);
        return ResponseEntity.ok(campaigns);
    }

    @PostMapping("/{campaignId}/schedule")
    public ResponseEntity<Void> scheduleCampaign(@PathVariable Long campaignId) {
        campaignService.scheduleCampaign(campaignId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{campaignId}/metrics")
    public ResponseEntity<Void> trackCampaignMetrics(@PathVariable Long campaignId) {
        campaignService.trackCampaignMetrics(campaignId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{campaignId}/segment-leads")
    public ResponseEntity<Void> segmentLeads(@PathVariable Long campaignId) {
        campaignService.segmentLeads(campaignId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{campaignId}/automate")
    public ResponseEntity<Void> automateCampaign(@PathVariable Long campaignId) {
        campaignService.automateCampaign(campaignId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{campaignId}/analyze")
    public ResponseEntity<CampaignDTO> analyzeCampaign(@PathVariable Long campaignId) {
        CampaignDTO campaignDTO = campaignService.analyzeCampaign(campaignId);
        return ResponseEntity.ok(campaignDTO);
    }
}
