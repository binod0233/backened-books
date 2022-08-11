package com.copenned.crm.controller;

import com.copenned.crm.dto.response.ListResponse.LeadListResponse;
import com.copenned.crm.dto.response.ListResponse.TeamLeadListResponse;
import com.copenned.crm.dto.response.SingleResponse.LeadResponse;
import com.copenned.crm.dto.response.SingleResponse.TeamLeadResponse;
import com.copenned.crm.model.Lead;
import com.copenned.crm.model.TeamLead;
import com.copenned.crm.service.LeadService;
import com.copenned.crm.service.TeamLeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class TeamLeadController {

    @Autowired
    private TeamLeadService teamLeadService;

    @PostMapping("/teamlead/register")
    public TeamLeadResponse addTeamLead(@RequestBody TeamLead teamlead){
        return teamLeadService.saveTeamLead(teamlead);
    }

    @GetMapping("/teamlead/teamleads")
    public TeamLeadListResponse findAllTeamLead(){
        return teamLeadService.getTeamLeads();
    }

    @GetMapping("/teamlead/teamleadId/{id}")
    public TeamLeadResponse findTeamLeadById(@PathVariable int id){
        return teamLeadService.getTeamLeadById(id);
    }

    @DeleteMapping("/teamlead/delete/{id}")
    public String deleteTeamLead(@PathVariable int id){
        return teamLeadService.deleteTeamLead(id);
    }




}
