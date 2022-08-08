package com.copenned.crm.service;

import com.copenned.crm.dto.response.ListResponse.SalesManListResponse;
import com.copenned.crm.dto.response.SingleResponse.SalesManResponse;
import com.copenned.crm.model.SalesMan;
import com.copenned.crm.repository.SalesManRepo;
import com.copenned.crm.utilities.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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

    public SalesManListResponse getSalesmanByTeamLead( String teamlead){
        return converter.convertToSalesmanList(repository.findAllByTeam(teamlead));
    }




    public String deleteSalesMan(int id){
        repository.deleteById(id);
        return "App User removed"+id;
    }

}
