package com.copenned.crm.dto.SingleResponse;

import com.copenned.crm.model.AppUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalesManResponse {

    @Column(name = "salesman_id")
    private int id;
    private String visibleTo;
    private String socialMedia;
    private String platform;
    private String team;
    private String teamLead;
    private int userId;
    private AppUser appUser;
}
