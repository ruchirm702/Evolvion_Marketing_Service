package dev.ruchir.evolvion_marketing_service.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class MarketingAutomationRuleDTO {

    private Long id;
    private String ruleName;
    private String triggerEvent; // e.g., "email_opened"
    private String action; // e.g., "send_follow_up_email"
    private Date triggerDate;
}
