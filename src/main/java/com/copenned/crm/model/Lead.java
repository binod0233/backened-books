package com.copenned.crm.model;

import com.copenned.crm.utilities.Memorialization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="[CopennedCRM].[dbo].[leads]")
@AllArgsConstructor
@NoArgsConstructor
public class Lead extends Extended implements Memorialization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name="work")
    private String  work;
    @Column(name="country")
    private String  country;
    @Column(name="gender")
    private String gender;
    @Column (name="client_background")
    private String clientBackground;
    @Column(name = "phone")
    private String phone;
    @Column(name = "source")
    private String source;
    @Column(name = "potential")
    private String potential;
    @Column(name = "next_follow_up_date")
    private Date nextFollowUpDate;
    @Column(name = "last_follow_up_date")
    private Date lastFollowUpDate;
    @Column(name = "social_media")
    private String socialMedia;
    @Column(name = "client_since")
    private Date clientSince = new Date();
    @Column(name="service_type")
    private String serviceType;
    @Column(name="service_plan")
    private String servicePlan;
    @Column(name="discipline")
    private String discipline;
    @Column(name="team_lead")
    private String teamLead;
    @Column(name="client_manager")
    private String clientManager;
    @Column(name="payment_method")
    private String paymentMethod;
    @Column(name="payee")
    private String payee;
    @Column(name="recipient")
    private String recipient;
    @Column(name="deal_value")
    private Double dealValue;
    @Column(name="due_date")
    private Date dueDate;
    @Column(name="payment_Status")
    private String paymentStatus;
    @Column(name = "created_by")
    private String createdBy ;
    @Column(name = "created_date")
    private Date createdDate = new Date();
    @Column(name = "modified_by")
    private String modifiedBy;
    @Column(name = "last_modified_date")
    private Date lastModifiedDate= new Date();
}
