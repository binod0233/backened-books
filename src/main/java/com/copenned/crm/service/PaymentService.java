package com.copenned.crm.service;


import com.copenned.crm.dto.ListResponse.PaymentsListResponse;
import com.copenned.crm.dto.SingleResponse.DashBoardEarningStats;
import com.copenned.crm.dto.SingleResponse.PaymentResponse;
import com.copenned.crm.dto.request.PaymentAttributeFilter;
import com.copenned.crm.dto.request.PotentialBody;
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
        System.out.println("trigerred");
        return converter.convertPayment(repository.save(payment));


    }

//    public PaymentResponse createPayment(PotentialBody potentialBody){
//        paymentRepository.save(new Payment(){{setPayee(potentialBody.getLeadName());setRemarks(potentialBody.getRemarks());setClientId(potentialBody.getLeadId());setTeamLead(potentialBody.getTeamLead());}});
//
//        return converter.convertPayment(repository.save(potentialBody));


//    }

    public PaymentsListResponse getPayments(){
        return  converter.convertToPaymentList(repository.findAll());
    }

    public PaymentResponse getPaymentById(int id){
        return  converter.convertPayment(repository.findById(id).orElse(null));
    }


    public PaymentsListResponse getWeeklyPayments(String period) {

        if(period.equals("monthly")){
            LocalDateTime timePeriod = LocalDateTime.now().minusDays(30);
            Date finalDate = converter.dateConverter(timePeriod);
            System.out.println(finalDate);
            return converter.convertToPaymentList(repository.findWeekly(finalDate));
        }
        else if(period.equals("semiMonthly")){
            LocalDateTime timePeriod = LocalDateTime.now().minusDays(15);
            Date finalDate = converter.dateConverter(timePeriod);
            System.out.println(finalDate);
            return converter.convertToPaymentList(repository.findWeekly(finalDate));
        }
        else if(period.equals("weekly")){
            LocalDateTime timePeriod = LocalDateTime.now().minusDays(7);
            Date finalDate = converter.dateConverter(timePeriod);
            System.out.println(finalDate);
            return converter.convertToPaymentList(repository.findWeekly(finalDate));

        }
else{
    return null;
        }
    }

    public PaymentsListResponse getTeamLeadWeeklyPayments(String period,String teamLead) {
        if(period.equals("monthly")){
            LocalDateTime timePeriod = LocalDateTime.now().minusDays(30);
            Date finalDate = converter.dateConverter(timePeriod);
            System.out.println(finalDate);
            return converter.convertToPaymentList(repository.findTeamLeadDataWeekly(finalDate,teamLead));
        }
        else if(period.equals("semiMonthly")){
            LocalDateTime timePeriod = LocalDateTime.now().minusDays(15);
            Date finalDate = converter.dateConverter(timePeriod);
            System.out.println(finalDate);
            return converter.convertToPaymentList(repository.findTeamLeadDataWeekly(finalDate,teamLead));
        }
        else if(period.equals("weekly")){
            LocalDateTime timePeriod = LocalDateTime.now().minusDays(7);
            Date finalDate = converter.dateConverter(timePeriod);
            System.out.println(finalDate);
            return converter.convertToPaymentList(repository.findTeamLeadDataWeekly(finalDate,teamLead));

        }
        else{
            return null;
        }
    }

    public PaymentsListResponse getClientManagerWeeklyPayments(String period, String clientManager) {
        if(period.equals("monthly")){
            LocalDateTime timePeriod = LocalDateTime.now().minusDays(30);
            Date finalDate = converter.dateConverter(timePeriod);
            System.out.println(finalDate);
            return converter.convertToPaymentList(repository.findClientManagerDataWeekly(finalDate,clientManager));
        }
        else if(period.equals("semiMonthly")){
            LocalDateTime timePeriod = LocalDateTime.now().minusDays(15);
            Date finalDate = converter.dateConverter(timePeriod);
            System.out.println(finalDate);
            return converter.convertToPaymentList(repository.findClientManagerDataWeekly(finalDate,clientManager));
        }
        else if(period.equals("weekly")){
            LocalDateTime timePeriod = LocalDateTime.now().minusDays(7);
            Date finalDate = converter.dateConverter(timePeriod);
            System.out.println(finalDate);
            return converter.convertToPaymentList(repository.findClientManagerDataWeekly(finalDate,clientManager));

        }
        else{
            return null;
        }
    }
    public PaymentsListResponse getPaymentsByClientManager(String clientManager){
        return  converter.convertToPaymentList( repository.findAllPaymentByRecipient(clientManager));
    }

    public PaymentsListResponse getPaymentsByTeamLead(String teamLead){


        return  converter.convertToPaymentList( repository.findAllPaymentByTeamLead(teamLead));
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

    public PaymentsListResponse  filterClientManagerPaymentsByAttribute(PaymentAttributeFilter filter)
    {
        List<Payment> paymentByLeadname = repository.findAllClientManagerPaymentsByPayee(filter.getLeadName(),filter.getRecipient());
        List<Payment> serviceTypeList = repository.findAllClientManagerPaymentsByServiceType(filter.getServiceType(),filter.getRecipient());
        List<Payment> amountList  = repository.findAllByClientManagerPaymentsAmountBetween(filter.getAmount1(), filter.getAmount2(),filter.getRecipient());
        List<Payment>  paymentMethodList = repository.findAllClientManagerPaymentsByPaymentMethod(filter.getPaymentMethod(),filter.getRecipient());
        List<Payment>  dateList= repository.findAllClientManagerPaymentsByPaymentDateBetween(filter.getDate1(), filter.getDate2(),filter.getRecipient());

        List<Payment> combinedList = new ArrayList<>();
        combinedList.addAll(serviceTypeList);
        combinedList.addAll(amountList);
        combinedList.addAll(paymentByLeadname);
        combinedList.addAll(paymentMethodList);
        combinedList.addAll(dateList);
        HashSet<Payment> hset = new HashSet<Payment>(combinedList);
        return converter.convertToPaymentList(new ArrayList<Payment>(hset));



    }

    public PaymentsListResponse  filterTeamLeadPaymentsByAttribute(PaymentAttributeFilter filter)
    {
        List<Payment> paymentByLeadname = repository.findAllTeamLeadPaymentsByPayee(filter.getLeadName(),filter.getTeamLead());
        List<Payment> serviceTypeList = repository.findAllTeamLeadPaymentsByServiceType(filter.getServiceType(),filter.getTeamLead());
        List<Payment> amountList  = repository.findAllTeamLeadPaymentsByAmountBetween(filter.getAmount1(), filter.getAmount2(),filter.getTeamLead());
        List<Payment>  recipientList  = repository.findAllTeamLeadPaymentsByRecipientContainingIgnoreCase(filter.getRecipient(),filter.getTeamLead());
        List<Payment>  paymentMethodList = repository.findAllTeamLeadPaymentsByPaymentMethod(filter.getPaymentMethod(),filter.getTeamLead());
        List<Payment>  dateList= repository.findAllTeamLeadPaymentsByPaymentDateBetween(filter.getDate1(), filter.getDate2(),filter.getTeamLead());

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


    public DashBoardEarningStats getDahboardStats(String filter) {
        Double totals=0.0;
        Double change=0.0;
        if(filter.equalsIgnoreCase("weekly"))
        {
            totals= repository.findTotalsBetweenDate(7);
            double lastTwoCombined= repository.findTotalsBetweenDate(14);
            double theOneBefore =lastTwoCombined-totals;
            change = ((totals-theOneBefore)/theOneBefore)*100;

        }
        else if ( filter.equalsIgnoreCase("monthly"))
        {
            totals= repository.findTotalsBetweenDate(7);
            double lastTwoCombined= repository.findTotalsBetweenDate(14);
            double theOneBefore =lastTwoCombined-totals;
            change = ((totals-theOneBefore)/theOneBefore)*100;

        }
        else if (filter.equalsIgnoreCase("semi-monthly")){
            totals= repository.findTotalsBetweenDate(15);
            double lastTwoCombined= repository.findTotalsBetweenDate(14);
            double theOneBefore =lastTwoCombined-totals;
            change = ((totals-theOneBefore)/theOneBefore)*100;

        }
        else {

            return new DashBoardEarningStats(totals,change);
        }
        return  new DashBoardEarningStats(totals,change);

    }
}
