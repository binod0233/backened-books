package com.copenned.crm.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentAttributeFilter {
   private String leadName;
 private String teamLead;
 private  String serviceType;
    private Double amount1;
    private  Double amount2;
    private  String recipient;
    private   String paymentMethod;
    private   Date date1;
    private   Date date2;



}
