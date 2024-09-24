package dev.ruchir.evolvion_marketing_service.model.Core;

import dev.ruchir.evolvion_marketing_service.model.Enums.ContentType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "content")
public class Content extends BaseModel {

    private String title;

    @Enumerated(EnumType.STRING)
    private ContentType type;

    private String url;

    private String description;
}
