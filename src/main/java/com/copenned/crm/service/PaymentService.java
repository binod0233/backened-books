package com.copenned.crm.service;


import com.copenned.crm.dto.response.ListResponse.PaymentsListResponse;
import com.copenned.crm.dto.response.SingleResponse.PaymentResponse;
import com.copenned.crm.model.Payment;
import com.copenned.crm.repository.PaymentRepo;
import com.copenned.crm.utilities.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class PaymentService {

    @Autowired
    private PaymentRepo repository;

    @Autowired
    private Converter converter;

    public PaymentResponse savePayment(Payment payment){
        return converter.convertPayment(repository.save(payment));


    }
    public PaymentResponse updatePayment(Payment payment){
        Payment existingPayment = repository.findById(payment.getPaymentId()).orElse(null);
        existingPayment.setAmount(payment.getAmount());
        existingPayment.setRemarks(payment.getRemarks());
        existingPayment.setModifiedBy(payment.getModifiedBy());
        return converter.convertPayment(repository.save(existingPayment));


    }

    public PaymentsListResponse getPayments(){
        return  converter.convertToPaymentList(repository.findAll());
    }

    public PaymentResponse getPaymentById(int id){
        return  converter.convertPayment(repository.findById(id).orElse(null));
    }



    public PaymentsListResponse getPaymentsByClientManager(String clientManager){
        return  converter.convertToPaymentList( repository.findAllPaymentByRecipient(clientManager));
    }

    public PaymentsListResponse getPaymentsByTeamLead(String teamLead){


        return  converter.convertToPaymentList( repository.findAllPaymentByRecipient(teamLead));
    }

}
