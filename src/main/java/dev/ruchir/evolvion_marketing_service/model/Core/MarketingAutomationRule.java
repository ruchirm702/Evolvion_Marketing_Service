package dev.ruchir.evolvion_marketing_service.model.Core;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "marketing_automation_rules")
public class MarketingAutomationRule extends BaseModel {
    private String ruleName;
    private String triggerEvent; // e.g., lead opens email, clicks on a link, etc.
    private String action; // e.g., send email, move to next stage
    private Date triggerDate;
}
