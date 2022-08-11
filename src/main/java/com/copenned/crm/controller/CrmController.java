package com.copenned.crm.controller;

import com.copenned.crm.dto.ListResponse.AppUsersListResponse;
import com.copenned.crm.dto.SingleResponse.AppUserResponse;
import com.copenned.crm.model.AppUser;
import com.copenned.crm.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class CrmController {
    @Autowired
    private AppUserService service;
//    @Autowired
//    private PaymentService paymentService;

//    @Autowired
//    private AccountService accountService;

//    @Autowired
//    private LeadService leadService;

//    @Autowired
//    private SalesManService salesManService;

//    @Autowired
//    private TeamLeadService teamLeadService;


    @PostMapping("/user/registerAppUser")
    public AppUserResponse addAppUser(@RequestBody AppUser appUser){
        System.out.println(appUser);
        return service.saveAppUser(appUser);
    }

    @GetMapping("/user/appUsers")
    public AppUsersListResponse findAllAppUsers(){
        return service.getAppUsers();
    }

    @GetMapping("/user/appUserId/{id}")
    public AppUserResponse findAppUserById(@PathVariable int id){
        return service.getAppUserById(id);
    }

    @GetMapping("/user/appUser/byname/{name}")
    public AppUserResponse findAppUserByName(@PathVariable String name){
        return service.getAppUserByName(name);
    }


    @PutMapping("/user/update")
    public AppUserResponse updateAppUsers(@RequestBody  AppUser appUser){
        return service.updateAppUser(appUser);
    }

    @DeleteMapping("/user/delete/{id}")
    public String deleteAppUser(@PathVariable int id){
        return service.deleteAppUser(id);
    }

//    @PostMapping("/payment/registerPayment")
//    public PaymentResponse addPayment(@RequestBody @Valid  Payment payment){
//        return paymentService.savePayment(payment);
//    }
//    @GetMapping("/payment/weekly-payments")
//    public PaymentsListResponse weeklyPayments(){
//        System.out.println("Login");
//        return paymentService.getWeeklyPayments();
//    }
//    @GetMapping("/payment/payments")
//    public PaymentsListResponse findAllPayments(){
//        return paymentService.getPayments();
//    }
//    @GetMapping("/payment/payments/getAllLeadsOfAClientManager/{clientManager}")
//    public PaymentsListResponse findAllPaymentsByClientManager(@PathVariable String clientManager){
//        return paymentService.getPaymentsByClientManager(clientManager);
//    }
//    @GetMapping("/payment/payments/getAllLeadsOfATeamLead/{teamLead}")
//    public String findAllPaymentsByTeamLead(@PathVariable String teamLead){
//        return "Logic left";
////        return paymentService.getPaymentsByTeamLead(teamLead);
//    }
//
////    @PutMapping("/payment/teamlead/update/{id}")
////    public PaymentResponse updatePayment(@RequestBody  Payment payment){
////        return paymentService.updatePayment(payment);
////    }
//    @GetMapping("/payment/paymentId/{id}")
//    public PaymentResponse findPaymentById(@PathVariable int id){
//        return paymentService.getPaymentById(id);
//    }
//
//    @PostMapping("/account/create")
//    public AccountResponse addAccount(@RequestBody Account account){
//        System.out.println(account);
//        return accountService.saveAccount(account);
//    }
//
//
//    @GetMapping("/account/all")
//    public AccountListResponse findAllAccount(){
//        return accountService.getAccounts();
//    }
//
//    @GetMapping("/account/appUserId/{id}")
//    public AccountResponse findAccountById(@PathVariable int id){
//        return accountService.getAccountById(id);
//    }
//
//    @PutMapping("/account/update")
//    public AccountResponse updateAccount(@RequestBody  Account account){
//        return accountService.updateAccount(account);
//    }
//
//    @DeleteMapping("/account/delete/{id}")
//    public String deleteAccount(@PathVariable int id){
//        return accountService.deleteAccount(id);
//    }



//    @PostMapping("/lead/registerLead")
//    public LeadResponse addAppUser(@RequestBody Lead lead){
//        System.out.println("apple");
//        return leadService.saveLead(lead);
//    }
//
//    @GetMapping("/lead/leads")
//    public LeadListResponse findAllLeads(){
//        return leadService.getLeads();
//    }
//
//    @GetMapping("/lead/leadId/{id}")
//    public LeadResponse findLeadById(@PathVariable int id){
//        return leadService.getLeadById(id);
//    }
//
//    @GetMapping("/lead/leads/{source}")
//    public LeadListResponse findAllBySource(@PathVariable String source){
//        return leadService.getLeadsBySource(source);
//    }
//    @GetMapping("/lead/leads/getAllLeadsOfAClientManager/{clientManager}")
//    public LeadListResponse findAllByClientManager(@PathVariable String clientManager){
//        return leadService.getLeadsByClientManager(clientManager);
//    }
//
//    @PutMapping("/lead/leads/changepotential/{leadId}")
//    public LeadResponse updateLeadDifficulty(@RequestBody  Lead lead,@PathVariable int leadId){
//        return leadService.updateLeadDifficulty(lead,leadId);
//    }
//
//    @PutMapping("/lead/teamlead/update")
//    public LeadResponse updateLeadTeamLead(@RequestBody  Lead lead){
//        return leadService.updateLeadTeamLead(lead);
//    }
//
//    @DeleteMapping("/lead/delete/{id}")
//    public String deleteLead(@PathVariable int id){
//        return leadService.deleteLead(id);
//    }

//    @PostMapping("/salesman/register")
//    public SalesManResponse addAppUser(@RequestBody SalesMan salesMan){
//        return salesManService.saveSalesMan(salesMan);
//    }
//
//    @GetMapping("/salesman/salesmen")
//    public SalesManListResponse findAllSalesMen(){
//        return salesManService.getSalesMen();
//    }
//
//    @GetMapping("/salesman/salesmanId/{id}")
//    public SalesManResponse findSalesManById(@PathVariable int id){
//
//        return salesManService.getSalesManById(id);
//    }
//
//    @GetMapping("/salesman/salesmen/getAllClientManagersOfATeamLead/{teamlead}")
//    public SalesManListResponse findAllByTeamLead(@PathVariable String teamlead){
//        return salesManService.getSalesmanByTeamLead(teamlead);
//    }
//    @DeleteMapping("/salesman/delete/{id}")
//    public String deleteSalesMan(@PathVariable int id){
//        return salesManService.deleteSalesMan(id);
//    }

//    @PostMapping("/teamlead/register")
//    public TeamLeadResponse addTeamLead(@RequestBody TeamLead teamlead){
//        return teamLeadService.saveTeamLead(teamlead);
//    }
//
//    @GetMapping("/teamlead/teamleads")
//    public TeamLeadListResponse findAllTeamLead(){
//        return teamLeadService.getTeamLeads();
//    }
//
//    @GetMapping("/teamlead/teamleadId/{id}")
//    public TeamLeadResponse findTeamLeadById(@PathVariable int id){
//        return teamLeadService.getTeamLeadById(id);
//    }
//
//    @DeleteMapping("/teamlead/delete/{id}")
//    public String deleteTeamLead(@PathVariable int id){
//        return teamLeadService.deleteTeamLead(id);
//    }
//

}
