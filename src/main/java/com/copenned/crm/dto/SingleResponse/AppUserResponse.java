package com.copenned.crm.dto.SingleResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AppUserResponse {

    private int id;
    private String userName;
    private String role;

    private String email;
    private String firstName;
    private String lastName;

    private String phone;

    private String createdBy ;
    private Date createdDate;
    private String modifiedBy;
    private Date lastModifiedDate;


}
