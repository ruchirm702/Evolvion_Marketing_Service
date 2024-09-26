package dev.ruchir.evolvion_marketing_service.dto;

import dev.ruchir.evolvion_marketing_service.model.Enums.ContactMethod;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactMethodDTO {
    private ContactMethod method; // Enum
    private String details; // Optional field for storing specific details
}
