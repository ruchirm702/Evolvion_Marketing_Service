package dev.ruchir.evolvion_marketing_service.dto;

import dev.ruchir.evolvion_marketing_service.model.Enums.CampaignType;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class CampaignDTO {

    private Long id;
    private String name;
    private CampaignType type; // Enum
    private Date startDate;
    private Date endDate;
    private Double budget;
    private String targetAudience;
    private List<CampaignMetricsDTO> performanceMetrics; // Nested DTO
    private Date createdAt;
    private Date updatedAt;
}
