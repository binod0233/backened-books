package com.copenned.crm.service;

import com.copenned.crm.dto.ListResponse.AccountListResponse;
import com.copenned.crm.dto.SingleResponse.AccountResponse;
import com.copenned.crm.model.Account;
import com.copenned.crm.repository.AccountRepo;
import com.copenned.crm.utilities.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountService {
    @Autowired
    private AccountRepo repository;
    @Autowired
    private Converter converter;
    public AccountResponse saveAccount(Account account){
        System.out.println(account);
        return converter.convertAccount(repository.save(account));

    }

    public AccountListResponse getAccounts(){
        return converter.convertToAccountList(repository.findAll());
    }

    public AccountResponse getAccountById(int id){
        return converter.convertAccount(repository.findById(id).orElse(null));
    }


    public String deleteAccount(int id){
        repository.deleteById(id);
        return "Account User removed"+id;
    }
    public AccountResponse updateAccount(Account account){
        Account existingAccount = repository.findById(account.getId()).orElse(null);
        existingAccount.setRemark(account.getRemark());
        existingAccount.setLastPayment(account.getLastPayment());
        existingAccount.setAmount(account.getAmount());
        return converter.convertAccount(repository.save(existingAccount));
    }


}
