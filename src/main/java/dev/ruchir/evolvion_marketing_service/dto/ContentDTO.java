package dev.ruchir.evolvion_marketing_service.dto;

import dev.ruchir.evolvion_marketing_service.model.Enums.ContentType;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class ContentDTO {

    private Long id;
    private String title;
    private ContentType type; // Enum
    private String url;
    private String description;
    private Date createdAt;
    private Date updatedAt;
}
