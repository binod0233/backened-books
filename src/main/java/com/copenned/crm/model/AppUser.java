package com.copenned.crm.model;

import com.copenned.crm.utilities.Memorialization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity
@Table(name="[CopennedCRM].[dbo].[Users]")
@AllArgsConstructor
@NoArgsConstructor
public class AppUser implements Memorialization{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "email")
    private String email;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;
    @Column(name = "phone")
    private String phone;
    @Column(name = "created_by")
    private String createdBy ;
    @Column(name = "created_date")
    private Date createdDate = new Date();
    @Column(name = "modified_by")
    private String modifiedBy;
    @Column(name = "last_modified_date")
    private Date lastModifiedDate;
    @Column(name = "activeFlag")
    private int activeFlag = 1;


    public AppUser(AppUser appUser) {
    }
}
