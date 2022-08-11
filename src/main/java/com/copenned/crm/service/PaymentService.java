package com.copenned.crm.service;


import com.copenned.crm.dto.response.ListResponse.PaymentsListResponse;
import com.copenned.crm.dto.response.SingleResponse.PaymentResponse;
import com.copenned.crm.model.Payment;
import com.copenned.crm.repository.PaymentRepo;
import com.copenned.crm.utilities.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service

public class PaymentService {

    @Autowired
    private PaymentRepo repository;

    @Autowired
    private Converter converter;

    public PaymentResponse savePayment(Payment payment){
        return converter.convertPayment(repository.save(payment));


    }

    public PaymentsListResponse getPayments(){
        return  converter.convertToPaymentList(repository.findAll());
    }

    public PaymentResponse getPaymentById(int id){
        return  converter.convertPayment(repository.findById(id).orElse(null));
    }


    public PaymentsListResponse getWeeklyPayments() {
        LocalDateTime week = LocalDateTime.now().minusDays(7);
        Date finalDate = converter.dateConverter(week);
        System.out.println(finalDate);
        return converter.convertToPaymentList(repository.findWeekly(finalDate));
    }
    public PaymentsListResponse getPaymentsByClientManager(String clientManager){
        return  converter.convertToPaymentList( repository.findAllPaymentByRecipient(clientManager));
    }

    public PaymentsListResponse getPaymentsByTeamLead(String teamLead){


        return  converter.convertToPaymentList( repository.findAllPaymentByRecipient(teamLead));
    }

}
