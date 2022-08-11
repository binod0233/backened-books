package com.copenned.crm.dto.SingleResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponse {

    private int id;
    private String remark;
    private int payment;
    private String lastPayment;
    private String LastPaymentBy;
    private Date amount;

}
