package com.copenned.crm.model;

import com.copenned.crm.utilities.Memorialization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.text.DecimalFormat;
import java.util.Date;

@Data
@Entity
@Table(name="[CopennedCRM].[dbo].[payments]")
@AllArgsConstructor
@NoArgsConstructor
public class Payment extends Extended implements Memorialization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private int paymentId;
    @Column(name = "client_id")
    private int clientId;
    @Column(name = "date")
    private Date paymentDate=new Date();
    @Column(name = "user_id")
    private int userId;
    @Column(name = "status")
    private String status;
    @Column(name = "payee")
    private String payee;
    @Column(name = "recipient")
    private String recipient;
    @Column(name = "service_type")
    private String teamLead;
    @Column(name = "team_lead")
    private String serviceType;
    @Column(name = "receipt")
    private String receipt;
    @Column(name = "amount")
    private Double amount;
    @Column(name = "remarks")
    private String remarks;
    @Column(name = "created_by")
    private String createdBy ;
    @Column(name = "created_date")
    private Date createdDate = new Date();
    @Column(name = "modified_by")
    private String modifiedBy;
    @Column(name = "last_modified_date")
    private Date lastModifiedDate= new Date();
    @Column(name = "payment_method")
    private String paymentMethod;

}
