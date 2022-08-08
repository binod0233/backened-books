package com.copenned.crm.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;
@MappedSuperclass
public class Extended {
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_date")
    private Date createdDate=new Date();
    @Column(name = "modified_by")
    private String modifiedBy;
    @Column(name = "last_modified_date")
    private Date lastModifiedDate=new Date();

}
