package com.copenned.crm.model;

import com.copenned.crm.utilities.Memorialization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="[CopennedCRM].[dbo].[accounts]")
@AllArgsConstructor
@NoArgsConstructor
public class Account extends Extended implements Memorialization {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "client_id")
        private int id;
        @Column(name = "remark")
        private String remark;
        @Column(name = "payment")
        private int payment;
        @Column(name = "last_payment")
        private String lastPayment;
        @Column(name = "last_payment_date")
        private String LastPaymentBy;
        @Column(name = "deal_amount")
        private Date amount;


}
