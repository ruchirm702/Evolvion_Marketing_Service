package dev.ruchir.evolvion_marketing_service.mappers;

import dev.ruchir.evolvion_marketing_service.dto.MarketingAutomationRuleDTO;
import dev.ruchir.evolvion_marketing_service.model.Core.MarketingAutomationRule;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MarketingAutomationRuleMapper {

    MarketingAutomationRuleDTO toDTO(MarketingAutomationRule marketingAutomationRule);
    MarketingAutomationRule toEntity(MarketingAutomationRuleDTO marketingAutomationRuleDTO);

    List<MarketingAutomationRuleDTO> toDTOList(List<MarketingAutomationRule> marketingAutomationRules);
    List<MarketingAutomationRule> toEntityList(List<MarketingAutomationRuleDTO> marketingAutomationRuleDTOs);
}
