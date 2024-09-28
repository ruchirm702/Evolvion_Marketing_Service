package dev.ruchir.evolvion_marketing_service.services.Implementations;

import dev.ruchir.evolvion_marketing_service.dto.LeadAnalyticsDTO;
import dev.ruchir.evolvion_marketing_service.dto.LeadDTO;
import dev.ruchir.evolvion_marketing_service.mappers.LeadAnalyticsMapper;
import dev.ruchir.evolvion_marketing_service.mappers.LeadMapper;
import dev.ruchir.evolvion_marketing_service.model.Core.Lead;
import dev.ruchir.evolvion_marketing_service.model.Enums.LeadQualification;
import dev.ruchir.evolvion_marketing_service.model.Enums.LeadSource;
import dev.ruchir.evolvion_marketing_service.model.Enums.LeadStatus;
import dev.ruchir.evolvion_marketing_service.repository.LeadRepository;
import dev.ruchir.evolvion_marketing_service.services.Interfaces.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeadServiceImpl implements LeadService {

    private final LeadRepository leadRepository;
    private final LeadMapper leadMapper; // Assuming you have a LeadMapper
    private final LeadAnalyticsMapper leadAnalyticsMapper;

    @Autowired
    public LeadServiceImpl(LeadRepository leadRepository, LeadMapper leadMapper, LeadAnalyticsMapper leadAnalyticsMapper) {
        this.leadRepository = leadRepository;
        this.leadMapper = leadMapper;
        this.leadAnalyticsMapper = leadAnalyticsMapper;
    }

    @Override
    public LeadDTO createLead(LeadDTO leadDTO) {
        Lead lead = leadMapper.toEntity(leadDTO);
        lead = leadRepository.save(lead);
        return leadMapper.toDTO(lead);
    }

    @Override
    public LeadDTO updateLead(Long leadId, LeadDTO leadDTO) {
        Lead existingLead = leadRepository.findById(leadId)
                .orElseThrow(() -> new IllegalArgumentException("Lead not found"));
        leadMapper.updateEntityFromDTO(leadDTO, existingLead);
        existingLead = leadRepository.save(existingLead);
        return leadMapper.toDTO(existingLead);
    }

    @Override
    public void deleteLead(Long leadId) {
        leadRepository.deleteById(leadId);
    }

    @Override
    public LeadDTO getLeadById(Long leadId) {
        Lead lead = leadRepository.findById(leadId)
                .orElseThrow(() -> new IllegalArgumentException("Lead not found"));
        return leadMapper.toDTO(lead);
    }

    @Override
    public List<LeadDTO> getAllLeads() {
        List<Lead> leads = leadRepository.findAll();
        return leadMapper.toDTOList(leads);
    }

    @Override
    public LeadDTO qualifyLead(Long leadId, LeadQualification qualification) {
        Lead lead = leadRepository.findById(leadId)
                .orElseThrow(() -> new IllegalArgumentException("Lead not found"));
        lead.setQualification(qualification);
        lead = leadRepository.save(lead);
        return leadMapper.toDTO(lead);
    }

    @Override
    public LeadDTO updateLeadStatus(Long leadId, LeadStatus status) {
        Lead lead = leadRepository.findById(leadId)
                .orElseThrow(() -> new IllegalArgumentException("Lead not found"));
        lead.setStatus(status);
        lead = leadRepository.save(lead);
        return leadMapper.toDTO(lead);
    }

    @Override
    public LeadDTO updateLeadSource(Long leadId, LeadSource source) {
        Lead lead = leadRepository.findById(leadId)
                .orElseThrow(() -> new IllegalArgumentException("Lead not found"));
        lead.setSource(source);
        lead = leadRepository.save(lead);
        return leadMapper.toDTO(lead);
    }

    @Override
    public LeadAnalyticsDTO getLeadAnalytics() {
        List<Lead> leads = leadRepository.findAll();
        return leadAnalyticsMapper.toDTO(leads);
    }
}
