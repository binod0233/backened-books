package com.copenned.crm.dto.response.ListResponse;


import com.copenned.crm.dto.response.SingleResponse.PaymentResponse;
import com.copenned.crm.model.Payment;
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
