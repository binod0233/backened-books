package com.copenned.crm.controller;

import com.copenned.crm.dto.ListResponse.SalesManListResponse;
import com.copenned.crm.dto.SingleResponse.SalesManResponse;
import com.copenned.crm.model.SalesMan;
import com.copenned.crm.service.SalesManService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class SalesManController {
    @Autowired
    private SalesManService salesManService;
    @PostMapping("/salesman/register")
    public SalesManResponse addAppUser(@RequestBody SalesMan salesMan){
        return salesManService.saveSalesMan(salesMan);
    }

    @GetMapping("/salesman/salesmen")
    public SalesManListResponse findAllSalesMen(){
        return salesManService.getSalesMen();
    }

    @GetMapping("/salesman/salesmanId/{id}")
    public SalesManResponse findSalesManById(@PathVariable int id){

        return salesManService.getSalesManById(id);
    }

    @PostMapping("/salesman/edit/{id}")
    public SalesManResponse editSalesMan(@PathVariable int id, @RequestBody SalesMan salesMan){

        return salesManService.editSalesMan(id,salesMan);
    }

    @GetMapping("/salesman/salesmen/getAllClientManagersOfATeamLead/{teamlead}")
    public SalesManListResponse findAllByTeamLead(@PathVariable String teamlead){
        return salesManService.getSalesmanByTeamLead(teamlead);
    }
    @DeleteMapping("/salesman/delete/{id}")
    public String deleteSalesMan(@PathVariable int id){
        return salesManService.deleteSalesMan(id);
    }
}
