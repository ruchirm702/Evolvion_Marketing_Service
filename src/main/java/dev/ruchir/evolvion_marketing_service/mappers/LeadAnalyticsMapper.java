package dev.ruchir.evolvion_marketing_service.mappers;


import dev.ruchir.evolvion_marketing_service.dto.LeadAnalyticsDTO;
import dev.ruchir.evolvion_marketing_service.model.Core.Lead;
import dev.ruchir.evolvion_marketing_service.model.Enums.LeadQualification;
import dev.ruchir.evolvion_marketing_service.model.Enums.LeadSource;
import dev.ruchir.evolvion_marketing_service.model.Enums.LeadStage;
import dev.ruchir.evolvion_marketing_service.model.Enums.LeadStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LeadAnalyticsMapper {

    // This method will create LeadAnalyticsDTO from the list of leads
    public LeadAnalyticsDTO toDTO(List<Lead> leads) {
        LeadAnalyticsDTO analyticsDTO = new LeadAnalyticsDTO();

        // Calculate totals and metrics
        analyticsDTO.setTotalLeads(leads.size());
        analyticsDTO.setConvertedLeads((int) leads.stream().filter(lead -> lead.getStatus() == LeadStatus.CONVERTED).count());
        analyticsDTO.setUnqualifiedLeads((int) leads.stream().filter(lead -> lead.getQualification() == LeadQualification.UNQUALIFIED).count());
        analyticsDTO.setContactedLeads((int) leads.stream().filter(lead -> lead.getStatus() == LeadStatus.CONTACTED).count());

        // Calculate conversion rate
        if (analyticsDTO.getTotalLeads() > 0) {
            analyticsDTO.setConversionRate((double) analyticsDTO.getConvertedLeads() / analyticsDTO.getTotalLeads() * 100);
        } else {
            analyticsDTO.setConversionRate(0.0);
        }

        // Count leads by source
        analyticsDTO.setLeadsBySourceSocialMedia((int) leads.stream().filter(lead -> lead.getSource() == LeadSource.SOCIAL_MEDIA).count());
        analyticsDTO.setLeadsBySourceReferral((int) leads.stream().filter(lead -> lead.getSource() == LeadSource.REFERRAL).count());
        analyticsDTO.setLeadsBySourcePPC((int) leads.stream().filter(lead -> lead.getSource() == LeadSource.PPC).count());
        analyticsDTO.setLeadsBySourceSEO((int) leads.stream().filter(lead -> lead.getSource() == LeadSource.SEO).count());
        analyticsDTO.setLeadsBySourceEmailMarketing((int) leads.stream().filter(lead -> lead.getSource() == LeadSource.EMAIL_MARKETING).count());
        analyticsDTO.setLeadsBySourceEvent((int) leads.stream().filter(lead -> lead.getSource() == LeadSource.EVENT).count());

        // Count leads in each stage
        analyticsDTO.setLeadsInStageAwareness((int) leads.stream().filter(lead -> lead.getStage() == LeadStage.AWARENESS).count());
        analyticsDTO.setLeadsInStageInterest((int) leads.stream().filter(lead -> lead.getStage() == LeadStage.INTEREST).count());
        analyticsDTO.setLeadsInStageConsideration((int) leads.stream().filter(lead -> lead.getStage() == LeadStage.CONSIDERATION).count());
        analyticsDTO.setLeadsInStageEvaluation((int) leads.stream().filter(lead -> lead.getStage() == LeadStage.EVALUATION).count());
        analyticsDTO.setLeadsInStageDecision((int) leads.stream().filter(lead -> lead.getStage() == LeadStage.DECISION).count());

        // Total leads closed
        analyticsDTO.setLeadsClosed((int) leads.stream().filter(lead -> lead.getStatus() == LeadStatus.CONVERTED || lead.getStatus() == LeadStatus.UNQUALIFIED).count());

        return analyticsDTO;
    }
}
