package com.copenned.crm.controller;

import com.copenned.crm.dto.ListResponse.AccountListResponse;
import com.copenned.crm.dto.SingleResponse.AccountResponse;
import com.copenned.crm.model.Account;
import com.copenned.crm.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@Component

@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/account/create")
    public AccountResponse addAccount(@RequestBody Account account){
        System.out.println(account);
        return accountService.saveAccount(account);
    }


    @GetMapping("/account/all")
    public AccountListResponse findAllAccount(){
        return accountService.getAccounts();
    }

    @GetMapping("/account/appUserId/{id}")
    public AccountResponse findAccountById(@PathVariable int id){
        return accountService.getAccountById(id);
    }

    @PutMapping("/account/update")
    public AccountResponse updateAccount(@RequestBody  Account account){
        return accountService.updateAccount(account);
    }

    @DeleteMapping("/account/delete/{id}")
    public String deleteAccount(@PathVariable int id){
        return accountService.deleteAccount(id);
    }


}
