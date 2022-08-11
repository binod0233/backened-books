package com.copenned.crm.dto.ListResponse;

import com.copenned.crm.dto.SingleResponse.AccountResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountListResponse {
    private List<AccountResponse> responseList;
}
