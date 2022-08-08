package com.copenned.crm.dto.response.ListResponse;

import com.copenned.crm.dto.response.SingleResponse.LeadResponse;
import com.copenned.crm.dto.response.SingleResponse.PaymentResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeadListResponse {
    private List<LeadResponse> responseList;


}
