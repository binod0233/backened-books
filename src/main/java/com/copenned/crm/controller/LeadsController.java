package com.copenned.crm.controller;

import com.copenned.crm.dto.ListResponse.LeadListResponse;
import com.copenned.crm.dto.ListResponse.PaymentsListResponse;
import com.copenned.crm.dto.SingleResponse.DashBoardEarningStats;
import com.copenned.crm.dto.SingleResponse.LeadResponse;
import com.copenned.crm.dto.SingleResponse.PaymentResponse;
import com.copenned.crm.dto.request.LeadAttributeFilter;
import com.copenned.crm.dto.request.PaymentAttributeFilter;
import com.copenned.crm.dto.request.PotentialBody;
import com.copenned.crm.model.Lead;
import com.copenned.crm.model.Payment;
import com.copenned.crm.service.LeadService;
import com.copenned.crm.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Component
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class LeadsController {
    @Autowired
    private LeadService leadService;

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/lead/registerLead")
    public LeadResponse addAppUser(@RequestBody Lead lead){
        System.out.println("apple");
        return leadService.saveLead(lead);
    }

    @GetMapping("/lead/weekly-payments/{period}")
    public LeadListResponse weeklyTeamLEadPayments(@PathVariable String period) {
        return leadService.getWeeklyLeads(period);
    }

    @GetMapping("/lead/weekly-payments/team-lead/{period}/{teamLead}")
    public LeadListResponse weeklyTeamLEadPayments(@PathVariable String period, @PathVariable String teamLead) {
        return leadService.getTeamLeadWeeklyLeads(period,teamLead);
    }
    @GetMapping("/lead/weekly-payments/client-manager/{period}/{clientManager}")
    public LeadListResponse weeklyClientManagerPayments(@PathVariable String period,@PathVariable String clientManager) {
        return leadService.getClientManagerWeeklyLeads(period,clientManager);
    }

    @PostMapping("/lead/attributeSearch")
    public LeadListResponse leadAttributeFilter(@RequestBody @Valid LeadAttributeFilter filter)
    {
        return leadService.filterByAttribute(filter);
    }

    @PostMapping("/lead/attributeSearch/clientManager")
    public LeadListResponse clientManagerLeadAttributeFilter(@RequestBody @Valid LeadAttributeFilter filter)
    {
        return leadService.filterClientManagerLeadsByAttribute(filter);
    }

    @PostMapping("/lead/attributeSearch/teamLead")
    public LeadListResponse teamLeadLeadAttributeFilter(@RequestBody @Valid LeadAttributeFilter filter)
    {
        return leadService.filterTeamLeadLeadsByAttribute(filter);
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

    @GetMapping("/lead/leads/getAllLeadsOfATeamLead/{teamLead}")
    public LeadListResponse findAllByTeamLead(@PathVariable String teamLead){

        return leadService.getLeadsByTeamLead(teamLead);
    }

    @PutMapping("/lead/leads/changepotential/{leadId}")
    public LeadResponse updateLeadDifficulty(@RequestBody PotentialBody potentialBody, @PathVariable int leadId){
//        paymentService.addPayment(potentialBody);
        return leadService.updateLeadDifficulty(potentialBody,leadId);
    }

    @PutMapping("/lead/teamlead/update")
    public LeadResponse updateLeadTeamLead(@RequestBody  Lead lead){
        return leadService.updateLeadTeamLead(lead);
    }

    @DeleteMapping("/lead/delete/{id}")
    public String deleteLead(@PathVariable int id){
        return leadService.deleteLead(id);
    }
        @GetMapping("/lead/get-deal-stats/{days}")
    public DashBoardEarningStats getDealStatsOnInterval(@PathVariable String days)
        {
            return  leadService.getPeriodicDealTotal(days);
        }
         @GetMapping("/lead/get-lead-stats/{days}")
    public DashBoardEarningStats getLeadStatsOnInterval(@PathVariable String days)
        {
            return  leadService.getPeriodicLeadStats(days);
        }

}
