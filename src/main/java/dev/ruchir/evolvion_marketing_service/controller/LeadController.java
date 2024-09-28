package dev.ruchir.evolvion_marketing_service.controller;

import dev.ruchir.evolvion_marketing_service.dto.LeadAnalyticsDTO;
import dev.ruchir.evolvion_marketing_service.dto.LeadDTO;
import dev.ruchir.evolvion_marketing_service.model.Enums.LeadQualification;
import dev.ruchir.evolvion_marketing_service.model.Enums.LeadSource;
import dev.ruchir.evolvion_marketing_service.model.Enums.LeadStatus;
import dev.ruchir.evolvion_marketing_service.services.Interfaces.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leads")
public class LeadController {

    private final LeadService leadService;

    @Autowired
    public LeadController(LeadService leadService) {
        this.leadService = leadService;
    }

    // Create a new lead
    @PostMapping
    public ResponseEntity<LeadDTO> createLead(@RequestBody LeadDTO leadDTO) {
        LeadDTO createdLead = leadService.createLead(leadDTO);
        return ResponseEntity.status(201).body(createdLead); // HTTP 201 Created
    }

    // Update an existing lead
    @PutMapping("/{leadId}")
    public ResponseEntity<LeadDTO> updateLead(@PathVariable Long leadId, @RequestBody LeadDTO leadDTO) {
        LeadDTO updatedLead = leadService.updateLead(leadId, leadDTO);
        return ResponseEntity.ok(updatedLead); // HTTP 200 OK
    }

    // Delete a lead
    @DeleteMapping("/{leadId}")
    public ResponseEntity<Void> deleteLead(@PathVariable Long leadId) {
        leadService.deleteLead(leadId);
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }

    // Get a lead by ID
    @GetMapping("/{leadId}")
    public ResponseEntity<LeadDTO> getLeadById(@PathVariable Long leadId) {
        LeadDTO lead = leadService.getLeadById(leadId);
        return ResponseEntity.ok(lead); // HTTP 200 OK
    }

    // Get all leads
    @GetMapping
    public ResponseEntity<List<LeadDTO>> getAllLeads() {
        List<LeadDTO> leads = leadService.getAllLeads();
        return ResponseEntity.ok(leads); // HTTP 200 OK
    }

    // Qualify a lead
    @PatchMapping("/{leadId}/qualify")
    public ResponseEntity<LeadDTO> qualifyLead(@PathVariable Long leadId, @RequestParam LeadQualification qualification) {
        LeadDTO qualifiedLead = leadService.qualifyLead(leadId, qualification);
        return ResponseEntity.ok(qualifiedLead); // HTTP 200 OK
    }

    // Update the status of a lead
    @PatchMapping("/{leadId}/status")
    public ResponseEntity<LeadDTO> updateLeadStatus(@PathVariable Long leadId, @RequestParam LeadStatus status) {
        LeadDTO updatedLead = leadService.updateLeadStatus(leadId, status);
        return ResponseEntity.ok(updatedLead); // HTTP 200 OK
    }

    // Update the source of a lead
    @PatchMapping("/{leadId}/source")
    public ResponseEntity<LeadDTO> updateLeadSource(@PathVariable Long leadId, @RequestParam LeadSource source) {
        LeadDTO updatedLead = leadService.updateLeadSource(leadId, source);
        return ResponseEntity.ok(updatedLead); // HTTP 200 OK
    }

    // Get lead analytics
    @GetMapping("/analytics")
    public ResponseEntity<LeadAnalyticsDTO> getLeadAnalytics() {
        LeadAnalyticsDTO analytics = leadService.getLeadAnalytics();
        return ResponseEntity.ok(analytics); // HTTP 200 OK
    }
}
