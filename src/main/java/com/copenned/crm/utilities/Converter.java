package com.copenned.crm.utilities;


import com.copenned.crm.dto.ListResponse.*;
import com.copenned.crm.dto.SingleResponse.*;
import com.copenned.crm.model.*;
import com.copenned.crm.service.AppUserService;
import com.copenned.crm.service.LeadService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class Converter {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private AppUserService appService;
    @Autowired
    private LeadService leadService;
    public PaymentResponse convertPayment(Payment payment)
    {
        Lead lead = mapper.map(leadService.getLeadById(payment.getClientId()), Lead.class);
        PaymentResponse response= mapper.map(payment,PaymentResponse.class);
        response.setLeadInfo(lead);
        return response;
    }
    public AppUserResponse convertAppUser(AppUser appUser)
    {
        return mapper.map(appUser, AppUserResponse.class);
    }
    public LeadResponse convertLead(Lead lead)
    {
        return mapper.map(lead, LeadResponse.class);
    }
    public TeamLeadResponse convertTeamLead(TeamLead teamLead)
    {
        AppUser user = mapper.map(appService.getAppUserById(teamLead.getUserId()),AppUser.class);

        TeamLeadResponse result = mapper.map(teamLead,TeamLeadResponse.class);
        result.setAppUser(user);
        return  result;
    }
    public SalesManResponse convertSalesMan(SalesMan salesMan)
    {
        AppUser user = mapper.map(appService.getAppUserById(salesMan.getUserId()),AppUser.class);

        SalesManResponse result = mapper.map(salesMan,SalesManResponse.class);
        result.setAppUser(user);
        return result;
    }
    public AccountResponse convertAccount(Account account)
    {

        return mapper.map(account, AccountResponse.class);
    }

    public PaymentsListResponse convertToPaymentList(List<Payment> paymentList)
    {
            List<PaymentResponse> responseList = new ArrayList<>();
            for(Payment p : paymentList)
            {
                responseList.add(convertPayment(p));
            }
            return new PaymentsListResponse(responseList);
    }
    public AccountListResponse convertToAccountList(List<Account> accountList)
    {
        List<AccountResponse> responseList = new ArrayList<>();
        for(Account a : accountList)
        {
            responseList.add(convertAccount(a));
        }
        return new AccountListResponse(responseList);
    }

    public AppUsersListResponse convertToAppUsersList(List<AppUser> appUserList)
    {
        List<AppUserResponse> responseList = new ArrayList<>();
        for(AppUser a : appUserList)
        {
            responseList.add(convertAppUser(a));
        }
        return new AppUsersListResponse(responseList);
    }

    public LeadListResponse convertToLeadList(List<Lead> leadList)
    {
        List<LeadResponse> responseList = new ArrayList<>();
        for(Lead a : leadList)
        {
            responseList.add(convertLead(a));
        }
        return new LeadListResponse(responseList);
    }

    public TeamLeadListResponse convertToTeamLead(List<TeamLead> teamLeadList)
    {
        List<TeamLeadResponse> responseList = new ArrayList<>();
        for(TeamLead a : teamLeadList)
        {
            responseList.add(convertTeamLead(a));
        }
        return new TeamLeadListResponse(responseList);
    }

    public SalesManListResponse convertToSalesmanList(List<SalesMan> salesManList)
    {
        List<SalesManResponse> responseList = new ArrayList<>();
        for(SalesMan a : salesManList)
        {
            responseList.add(convertSalesMan(a));
        }
        return new SalesManListResponse(responseList);
    }
    public Date dateConverter(LocalDateTime week)
    {
        Date finalDate= Date.from(week.atZone(ZoneId.systemDefault()).toInstant());
        return finalDate;
    }



}
