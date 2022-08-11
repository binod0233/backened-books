package com.copenned.crm.controller;

import com.copenned.crm.dto.ListResponse.LeadListResponse;
import com.copenned.crm.dto.SingleResponse.LeadResponse;
import com.copenned.crm.model.Lead;
import com.copenned.crm.service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class LeadsController {
    @Autowired
    private LeadService leadService;
    @PostMapping("/lead/registerLead")
    public LeadResponse addAppUser(@RequestBody Lead lead){
        System.out.println("apple");
        return leadService.saveLead(lead);
    }

    @GetMapping("/lead/leads")
    public LeadListResponse findAllLeads(){
        return leadService.getLeads();
    }

    @GetMapping("/lead/leadId/{id}")
    public LeadResponse findLeadById(@PathVariable int id){
        return leadService.getLeadById(id);
    }

    @GetMapping("/lead/leads/{source}")
    public LeadListResponse findAllBySource(@PathVariable String source){
        return leadService.getLeadsBySource(source);
    }
    @GetMapping("/lead/leads/getAllLeadsOfAClientManager/{clientManager}")
    public LeadListResponse findAllByClientManager(@PathVariable String clientManager){
        return leadService.getLeadsByClientManager(clientManager);
    }

    @PutMapping("/lead/leads/changepotential/{leadId}")
    public LeadResponse updateLeadDifficulty(@RequestBody  Lead lead,@PathVariable int leadId){
        return leadService.updateLeadDifficulty(lead,leadId);
    }

    @PutMapping("/lead/teamlead/update")
    public LeadResponse updateLeadTeamLead(@RequestBody  Lead lead){
        return leadService.updateLeadTeamLead(lead);
    }

    @DeleteMapping("/lead/delete/{id}")
    public String deleteLead(@PathVariable int id){
        return leadService.deleteLead(id);
    }


}
