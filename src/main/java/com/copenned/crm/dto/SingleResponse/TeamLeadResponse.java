package com.copenned.crm.dto.SingleResponse;

import com.copenned.crm.model.AppUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamLeadResponse {

    private int id;

    private int userId;

    private String teamName;

    private AppUser appUser;
}


