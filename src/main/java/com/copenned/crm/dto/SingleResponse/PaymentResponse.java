package com.copenned.crm.dto.SingleResponse;

import com.copenned.crm.utilities.MemorializationResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponse  {

    private int paymentId;
    private int clientId;
    private Date paymentDate;
    private int userId;
    private Double amount;
    private String remarks;
    private String status;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date lastModifiedDate;
    private String payee;
    private String recipient;
    private String serviceType;
    private String receipt;
    private String paymentMethod;
}
