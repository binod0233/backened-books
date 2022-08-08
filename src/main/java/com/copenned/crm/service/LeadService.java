package com.copenned.crm.service;

import com.copenned.crm.dto.response.ListResponse.LeadListResponse;
import com.copenned.crm.dto.response.SingleResponse.LeadResponse;
import com.copenned.crm.model.AppUser;
import com.copenned.crm.model.Lead;
import com.copenned.crm.repository.AppUserRepo;
import com.copenned.crm.repository.LeadRepo;
import com.copenned.crm.utilities.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeadService {

    @Autowired
    private LeadRepo repository;
    @Autowired
    private Converter converter;
    public LeadResponse saveLead(Lead lead){

        return converter.convertLead(repository.save(lead));

    }

    public LeadListResponse getLeads(){
        return converter.convertToLeadList(repository.findAll());
    }


    public LeadResponse getLeadById(int id){
        return converter.convertLead(repository.findById(id).orElse(null));
    }


    public String deleteLead(int id){
        repository.deleteById(id);
        return "Lead removed"+id;
    }
    public LeadListResponse getLeadsBySource(String source){
        return converter.convertToLeadList(repository.findAllBySource(source));
    }
    public LeadListResponse getLeadsByClientManager(String source){
        return converter.convertToLeadList(repository.findAllByClientManager(source));
    }
    public LeadResponse updateLeadDifficulty(Lead lead,int leadId){
        Lead existingLead = repository.findById(leadId).orElse(null);
        existingLead.setPotential(lead.getPotential());

        return converter.convertLead(repository.save(existingLead));
    }

    public LeadResponse updateLeadTeamLead(Lead lead){
        Lead existingLead = repository.findById(lead.getId()).orElse(null);
        existingLead.setName(lead.getName());
        existingLead.setEmail(lead.getEmail());
        existingLead.setPhone(lead.getPhone());
        existingLead.setSource(lead.getSource());
        return converter.convertLead(repository.save(existingLead));
    }

}
