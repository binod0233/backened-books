package com.copenned.crm.model;


import com.copenned.crm.utilities.Memorialization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="[CopennedCRM].[dbo].[teamlead]")
@AllArgsConstructor
@NoArgsConstructor
public class TeamLead extends Extended implements Memorialization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teamlead_id")
    private int id;
    @Column(name="user_id")
    private int userId;
    @Column(name = "team_name")
    private String teamName;
}
