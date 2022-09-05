package com.copenned.crm.service;

import com.copenned.crm.dto.ListResponse.LeadListResponse;
import com.copenned.crm.dto.ListResponse.PaymentsListResponse;
import com.copenned.crm.dto.SingleResponse.LeadResponse;
import com.copenned.crm.dto.SingleResponse.PaymentResponse;
import com.copenned.crm.dto.request.LeadAttributeFilter;
import com.copenned.crm.dto.request.PaymentAttributeFilter;
import com.copenned.crm.dto.request.PotentialBody;
import com.copenned.crm.model.Lead;
import com.copenned.crm.model.Payment;
import com.copenned.crm.repository.LeadRepo;
import com.copenned.crm.repository.PaymentRepo;
import com.copenned.crm.utilities.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Service
public class LeadService {


    @Autowired
    private LeadRepo repository;
    @Autowired
    private PaymentService paymentRepository;
    @Autowired
    private Converter converter;


    public LeadResponse saveLead(Lead lead) {

        return converter.convertLead(repository.save(lead));

    }

    public LeadListResponse getWeeklyLeads(String period) {

        if(period.equals("monthly")){
            LocalDateTime timePeriod = LocalDateTime.now().minusDays(30);
            Date finalDate = converter.dateConverter(timePeriod);
            System.out.println(finalDate);
            return converter.convertToLeadList(repository.findWeekly(finalDate));
        }
        else if(period.equals("semiMonthly")){
            LocalDateTime timePeriod = LocalDateTime.now().minusDays(15);
            Date finalDate = converter.dateConverter(timePeriod);
            System.out.println(finalDate);
            return converter.convertToLeadList(repository.findWeekly(finalDate));
        }
        else if(period.equals("weekly")){
            LocalDateTime timePeriod = LocalDateTime.now().minusDays(7);
            Date finalDate = converter.dateConverter(timePeriod);
            System.out.println(finalDate);
            return converter.convertToLeadList(repository.findWeekly(finalDate));

        }
        else{
            return null;
        }
    }

    public LeadListResponse getTeamLeadWeeklyLeads(String period,String teamLead) {
        if(period.equals("monthly")){
            LocalDateTime timePeriod = LocalDateTime.now().minusDays(30);
            Date finalDate = converter.dateConverter(timePeriod);
            System.out.println(finalDate);
            return converter.convertToLeadList(repository.findTeamLeadDataWeekly(finalDate,teamLead));
        }
        else if(period.equals("semiMonthly")){
            LocalDateTime timePeriod = LocalDateTime.now().minusDays(15);
            Date finalDate = converter.dateConverter(timePeriod);
            System.out.println(finalDate);
            return converter.convertToLeadList(repository.findTeamLeadDataWeekly(finalDate,teamLead));
        }
        else if(period.equals("weekly")){
            LocalDateTime timePeriod = LocalDateTime.now().minusDays(7);
            Date finalDate = converter.dateConverter(timePeriod);
            System.out.println(finalDate);
            return converter.convertToLeadList(repository.findTeamLeadDataWeekly(finalDate,teamLead));

        }
        else{
            return null;
        }
    }

    public LeadListResponse getClientManagerWeeklyLeads(String period, String clientManager) {
        if(period.equals("monthly")){
            LocalDateTime timePeriod = LocalDateTime.now().minusDays(30);
            Date finalDate = converter.dateConverter(timePeriod);
            System.out.println(finalDate);
            return converter.convertToLeadList(repository.findClientManagerDataWeekly(finalDate,clientManager));
        }
        else if(period.equals("semiMonthly")){
            LocalDateTime timePeriod = LocalDateTime.now().minusDays(15);
            Date finalDate = converter.dateConverter(timePeriod);
            System.out.println(finalDate);
            return converter.convertToLeadList(repository.findClientManagerDataWeekly(finalDate,clientManager));
        }
        else if(period.equals("weekly")){
            LocalDateTime timePeriod = LocalDateTime.now().minusDays(7);
            Date finalDate = converter.dateConverter(timePeriod);
            System.out.println(finalDate);
            return converter.convertToLeadList(repository.findClientManagerDataWeekly(finalDate,clientManager));

        }
        else{
            return null;
        }
    }

    public LeadListResponse getLeads() {
        return converter.convertToLeadList(repository.findAll());
    }


    public LeadResponse getLeadById(int id) {
        return converter.convertLead(repository.findById(id).orElse(null));
    }


    public String deleteLead(int id) {
        repository.deleteById(id);
        return "Lead removed" + id;
    }

    public LeadListResponse getLeadsBySource(String source) {
        return converter.convertToLeadList(repository.findAllBySource(source));
    }

    public LeadListResponse getLeadsByClientManager(String source) {
        return converter.convertToLeadList(repository.findAllByClientManager(source));
    }

    public LeadListResponse getLeadsByTeamLead(String source) {
        return converter.convertToLeadList(repository.findAllByTeamLead(source));
    }

    public LeadResponse updateLeadDifficulty( PotentialBody potentialBody, int leadId) {
        Lead existingLead = repository.findById(leadId).orElse(null);
        existingLead.setPotential(potentialBody.getPotential());

        if(potentialBody.getPotential().equals("won")){
//        PaymentResponse t = paymentRepository.savePayment(new Payment(){{setPayee(potentialBody.getLeadName());setRecipient(potentialBody.getClientManager());setRemarks(potentialBody.getRemarks());setClientId(potentialBody.getLeadId());setTeamLead(potentialBody.getTeamLead());}});
        Payment p = new Payment();
        p.setPayee(potentialBody.getLeadName());
        p.setRecipient(potentialBody.getClientManager());
        p.setCreatedDate(new Date());
        p.setClientId(potentialBody.getLeadId());
        p.setTeamLead(potentialBody.getTeamLead());
        System.out.println(paymentRepository.savePayment(p));
        }



        return converter.convertLead(repository.save(existingLead));
    }

    public LeadResponse updateLead( Lead lead,int leadId) {
        Lead existingLead = repository.findById(leadId).orElse(null);
        existingLead.setServicePlan(lead.getServicePlan());
        existingLead.setServiceType(lead.getServiceType());
        existingLead.setSource(lead.getSource());
        existingLead.setPotential(lead.getPotential());
        existingLead.setSocialMedia(lead.getSocialMedia());
        existingLead.setLastFollowUpDate(lead.getLastFollowUpDate());
        existingLead.setNextFollowUpDate(lead.getNextFollowUpDate());
        existingLead.setDiscipline(lead.getDiscipline());


        return converter.convertLead(repository.save(existingLead));
    }

    public LeadResponse updateLeadTeamLead(Lead lead) {
        Lead existingLead = repository.findById(lead.getId()).orElse(null);
        existingLead.setName(lead.getName());
        existingLead.setEmail(lead.getEmail());
        existingLead.setWork(lead.getWork());
        existingLead.setPhone(lead.getPhone());
        existingLead.setSource(lead.getSource());
        existingLead.setSocialMedia(lead.getSocialMedia());
        existingLead.setTeamLead(lead.getTeamLead());
        existingLead.setRecipient(lead.getRecipient());



        return converter.convertLead(repository.save(existingLead));
    }


    //filter the leads
    public LeadListResponse filterByAttribute(LeadAttributeFilter filter) {
        List<Lead> paymentByLeadname = repository.findAllByName(filter.getLeadName());
        List<Lead> serviceTypeList = repository.findAllByServiceType(filter.getServiceType());
        List<Lead> amountList = repository.findAllByDealValue(filter.getAmount());
        List<Lead> recipientList = repository.findAllByPotential(filter.getPotential());
        List<Lead> dateList = repository.findAllByCreatedDate(filter.getDate1());

        List<Lead> combinedList = new ArrayList<>();
        combinedList.addAll(serviceTypeList);
        combinedList.addAll(amountList);
        combinedList.addAll(recipientList);
        combinedList.addAll(paymentByLeadname);
        combinedList.addAll(dateList);
        HashSet<Lead> hset = new HashSet<Lead>(combinedList);
        return converter.convertToLeadList(new ArrayList<Lead>(hset));


    }

    public LeadListResponse filterTeamLeadLeadsByAttribute(LeadAttributeFilter filter) {
        List<Lead> leadByLeadname = repository.findAllTeamLeadLeadsByLeadName(filter.getLeadName(),filter.getTeamLead());
        List<Lead> serviceTypeList = repository.findAllTeamLeadLeadsByServiceType(filter.getServiceType(),filter.getTeamLead());
        List<Lead> amountList = repository.findAllTeamLeadLeadsByAmount(filter.getAmount(), filter.getTeamLead());
        List<Lead> recipientList = repository.findAllTeamLeadLeadsByPotential(filter.getPotential(),filter.getTeamLead());
        List<Lead> dateList = repository.findAllTeamLeadLeadsByCreatedDate(filter.getDate1(),filter.getTeamLead());

        List<Lead> combinedList = new ArrayList<>();
        combinedList.addAll(serviceTypeList);
        combinedList.addAll(amountList);
        combinedList.addAll(recipientList);
        combinedList.addAll(leadByLeadname);
        combinedList.addAll(dateList);
        HashSet<Lead> hset = new HashSet<Lead>(combinedList);
        return converter.convertToLeadList(new ArrayList<Lead>(hset));


    }

    public LeadListResponse filterClientManagerLeadsByAttribute(LeadAttributeFilter filter) {
        List<Lead> leadByLeadname = repository.findAllClientManagerLeadsByLeadName(filter.getLeadName(),filter.getClientManager());
        List<Lead> serviceTypeList = repository.findAllClientManagerLeadsByServiceType(filter.getServiceType(),filter.getClientManager());
        List<Lead> amountList = repository.findAllClientManagerLeadsByAmount(filter.getAmount(), filter.getClientManager());
        List<Lead> recipientList = repository.findAllClientManagerLeadsByPotential(filter.getPotential(),filter.getClientManager());
        List<Lead> dateList = repository.findAllClientManagerLeadsByCreatedDate(filter.getDate1(),filter.getClientManager());

        List<Lead> combinedList = new ArrayList<>();
        combinedList.addAll(serviceTypeList);
        combinedList.addAll(amountList);
        combinedList.addAll(recipientList);
        combinedList.addAll(leadByLeadname);
        combinedList.addAll(dateList);
        HashSet<Lead> hset = new HashSet<Lead>(combinedList);
        return converter.convertToLeadList(new ArrayList<Lead>(hset));


    }

}