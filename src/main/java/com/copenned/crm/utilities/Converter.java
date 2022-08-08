package com.copenned.crm.utilities;


import com.copenned.crm.dto.response.ListResponse.*;
import com.copenned.crm.dto.response.SingleResponse.*;
import com.copenned.crm.model.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Converter {
    @Autowired
    private ModelMapper mapper;
    public PaymentResponse convertPayment(Payment payment)
    {
        return mapper.map(payment, PaymentResponse.class);
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
        return mapper.map(teamLead, TeamLeadResponse.class);
    }
    public SalesManResponse convertSalesMan(SalesMan salesMan)
    {
        return mapper.map(salesMan, SalesManResponse.class);
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




}
