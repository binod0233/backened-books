package com.copenned.crm.service;


import com.copenned.crm.dto.ListResponse.PaymentsListResponse;
import com.copenned.crm.dto.SingleResponse.PaymentResponse;
import com.copenned.crm.dto.request.PaymentAttributeFilter;
import com.copenned.crm.model.Payment;
import com.copenned.crm.repository.PaymentRepo;
import com.copenned.crm.utilities.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

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
//
//    /api/payment/clientManager/payments?leadname=””&&serviceType=””&&amount=””&&recepient=””&&paymentMethod=””&&date=””
//
    public PaymentsListResponse  filterByAttribute(PaymentAttributeFilter filter)
    {
        List<Payment> paymentByLeadname = repository.findAllByPayee(filter.getLeadName());
        List<Payment> serviceTypeList = repository.findAllByServiceType(filter.getServiceType());
        List<Payment> amountList  = repository.findAllByAmountBetween(filter.getAmount1(), filter.getAmount2());
        List<Payment>  recipientList  = repository.findAllByRecipientContainingIgnoreCase(filter.getRecipient());
        List<Payment>  paymentMethodList = repository.findAllByPaymentMethod(filter.getPaymentMethod());
        List<Payment>  dateList= repository.findAllByPaymentDateBetween(filter.getDate1(), filter.getDate2());

        List<Payment> combinedList = new ArrayList<>();
        combinedList.addAll(serviceTypeList);
        combinedList.addAll(amountList);
        combinedList.addAll(recipientList);
        combinedList.addAll(paymentByLeadname);
        combinedList.addAll(paymentMethodList);
        combinedList.addAll(dateList);
        HashSet<Payment> hset = new HashSet<Payment>(combinedList);
        return converter.convertToPaymentList(new ArrayList<Payment>(hset));



    }
}
