package com.copenned.crm.utilities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


public interface Memorialization {

    @Column(name = "created_by")
    String createdBy = null;
    @Column(name = "created_date")
    Date createdDate = new Date();
    @Column(name = "modified_by")
    String modifiedBy = null;
    @Column(name = "last_modified_date")
    Date lastModifiedDate= new Date();
}
