package dev.ruchir.evolvion_marketing_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LeadAnalyticsDTO {

    private long totalLeads; // Total number of leads in the system
    private long convertedLeads; // Number of leads that have been successfully converted
    private long unqualifiedLeads; // Number of leads that were disqualified
    private long contactedLeads; // Number of leads that have been contacted
    private double conversionRate; // Conversion percentage (calculated as convertedLeads / totalLeads * 100)
    private long leadsBySourceSocialMedia; // Leads generated from social media
    private long leadsBySourceReferral; // Leads generated through referrals
    private long leadsBySourcePPC; // Leads generated from pay-per-click (PPC) campaigns
    private long leadsBySourceSEO; // Leads generated from SEO efforts
    private long leadsBySourceEmailMarketing; // Leads generated via email marketing
    private long leadsBySourceEvent; // Leads generated through events
    private long leadsInStageAwareness; // Leads in the awareness stage of the funnel
    private long leadsInStageInterest; // Leads in the interest stage of the funnel
    private long leadsInStageConsideration; // Leads in the consideration stage of the funnel
    private long leadsInStageEvaluation; // Leads in the evaluation stage of the funnel
    private long leadsInStageDecision; // Leads in the decision stage of the funnel
    private long leadsClosed; // Number of leads that have been closed (either won or lost)

}