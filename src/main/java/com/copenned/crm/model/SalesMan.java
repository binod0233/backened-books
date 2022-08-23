package com.copenned.crm.model;


import com.copenned.crm.utilities.Memorialization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="[CopennedCRM].[dbo].[salesman]")
@AllArgsConstructor
@NoArgsConstructor
public class SalesMan extends Extended implements Memorialization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "salesman_id")
    private int id;

    @Column (name="lead_name")
    private String leadName;

    @Column (name="visible_to")
    private String visibleTo;

    @Column (name="social_media")
    private String socialMedia;

    @Column (name="platform")
    private String platform;
    @Column(name = "team")

    private String team;

    @Column(name = "team_lead")

    private String teamLead;

    @Column(name = "user_id")
    private int userId;
}
