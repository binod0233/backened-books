package com.copenned.crm.dto.SingleResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeadResponse {

    

    private int id;
    private String name;
    private String email;
    private String  work;
    private String gender;
    private String clientBackground;
    private String phone;
    private String source;
    private String potential;
    private Date nextFollowUpDate;
    private Date lastFollowUpDate;
    private String socialMedia;
    private Date clientSince;
    private String serviceType;
    private String servicePlan;
    private String discipline;
    private String teamLead;
    private String clientManager;
    private String paymentMethod;
    private String payee;
    private String recipient;
    private Double dealValue;
    private Date dueDate;
    private String paymentStatus;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date lastModifiedDate;
}
