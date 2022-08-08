package com.copenned.crm.dto.response.ListResponse;

import com.copenned.crm.dto.response.SingleResponse.SalesManResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalesManListResponse {
    private List<SalesManResponse> responseList;
}
