package com.copenned.crm.service;

import com.copenned.crm.dto.response.ListResponse.TeamLeadListResponse;
import com.copenned.crm.dto.response.SingleResponse.TeamLeadResponse;
import com.copenned.crm.model.TeamLead;
import com.copenned.crm.repository.TeamLeadRepo;
import com.copenned.crm.utilities.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamLeadService {

    @Autowired
    private TeamLeadRepo repository;
    @Autowired
    private Converter converter;
    public TeamLeadResponse saveTeamLead(TeamLead teamLead){

        return converter.convertTeamLead(repository.save(teamLead));

    }

    public TeamLeadListResponse getTeamLeads(){
        return converter.convertToTeamLead(repository.findAll());
    }

    public TeamLeadResponse getTeamLeadById(int id){
        return converter.convertTeamLead(repository.findById(id).orElse(null));
    }


    public String deleteTeamLead(int id){
        repository.deleteById(id);
        return "TeamLead removed"+id;
    }

}
