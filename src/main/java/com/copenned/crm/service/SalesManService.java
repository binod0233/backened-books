package com.copenned.crm.service;

import com.copenned.crm.dto.ListResponse.SalesManListResponse;
import com.copenned.crm.dto.SingleResponse.SalesManResponse;
import com.copenned.crm.model.Lead;
import com.copenned.crm.model.Payment;
import com.copenned.crm.model.SalesMan;
import com.copenned.crm.repository.SalesManRepo;
import com.copenned.crm.utilities.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class SalesManService {
    @Autowired
    private SalesManRepo repository;
    @Autowired
    private Converter converter;
    public SalesManResponse saveSalesMan(SalesMan salesMan){

        return converter.convertSalesMan(repository.save(salesMan));

    }

    public SalesManListResponse getSalesMen(){
        return converter.convertToSalesmanList(repository.findAll());
    }

    public SalesManResponse getSalesManById(int id){
        return converter.convertSalesMan(repository.findById(id).orElse(null));
    }

    public SalesManResponse editSalesMan(int id,SalesMan salesMan){
        SalesMan existingSalesman = repository.findById(id).orElse(null);
        existingSalesman.setPlatform(salesMan.getPlatform());
        existingSalesman.setTeamLead(salesMan.getTeamLead());
        existingSalesman.setTeam(salesMan.getTeam());
        return converter.convertSalesMan(repository.save(existingSalesman));
    }

    public SalesManListResponse getSalesmanByTeamLead( String teamlead){
        return converter.convertToSalesmanList(repository.findAllByTeamLead(teamlead));
    }




    public String deleteSalesMan(int id){
        repository.deleteById(id);
        return "App User removed"+id;
    }

}
