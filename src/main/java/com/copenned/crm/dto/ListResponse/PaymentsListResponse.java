package com.copenned.crm.dto.ListResponse;


import com.copenned.crm.dto.SingleResponse.PaymentResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentsListResponse {
    private List<PaymentResponse> responseList;
}
