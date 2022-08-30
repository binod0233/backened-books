package com.copenned.crm.dto.request;

import com.copenned.crm.model.AppUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUserRequest {
    private AppUser user;
    private String leadName;
    private int leadId;

}
