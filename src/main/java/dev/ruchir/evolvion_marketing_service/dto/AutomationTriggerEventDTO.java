package dev.ruchir.evolvion_marketing_service.dto;

import dev.ruchir.evolvion_marketing_service.model.Enums.AutomationTriggerEvent;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutomationTriggerEventDTO {
    private AutomationTriggerEvent event; // Enum
    private String description; // Optional for more details on the trigger
}
