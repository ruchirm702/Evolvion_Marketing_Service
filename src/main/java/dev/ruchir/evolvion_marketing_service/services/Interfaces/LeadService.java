package dev.ruchir.evolvion_marketing_service.services.Interfaces;

import dev.ruchir.evolvion_marketing_service.dto.LeadAnalyticsDTO;
import dev.ruchir.evolvion_marketing_service.dto.LeadDTO;
import dev.ruchir.evolvion_marketing_service.dto.LeadActivityDTO;
import dev.ruchir.evolvion_marketing_service.model.Enums.LeadQualification;
import dev.ruchir.evolvion_marketing_service.model.Enums.LeadSource;
import dev.ruchir.evolvion_marketing_service.model.Enums.LeadStatus;

import java.util.List;

public interface LeadService {

    // Create a new lead
    LeadDTO createLead(LeadDTO leadDTO);

    // Update an existing lead by ID
    LeadDTO updateLead(Long leadId, LeadDTO leadDTO);

    // Delete a lead by ID
    void deleteLead(Long leadId);

    // Retrieve a lead by ID
    LeadDTO getLeadById(Long leadId);

    // Retrieve all leads
    List<LeadDTO> getAllLeads();

    // Qualify a lead based on specific criteria (e.g., engagement level, demographics)
    LeadDTO qualifyLead(Long leadId, LeadQualification qualification);

    // Update the status of a lead (e.g., new, contacted, converted)
    LeadDTO updateLeadStatus(Long leadId, LeadStatus status);

    // Track the source of the lead (e.g., ads, social media, referrals)
    LeadDTO updateLeadSource(Long leadId, LeadSource source);

    // Manage activities related to a lead (e.g., calls, emails, follow-ups)
    LeadActivityDTO addLeadActivity(Long leadId, LeadActivityDTO activityDTO);

    List<LeadActivityDTO> getLeadActivities(Long leadId);

    // Provide analytics on lead generation and conversions
    LeadAnalyticsDTO getLeadAnalytics();
}
