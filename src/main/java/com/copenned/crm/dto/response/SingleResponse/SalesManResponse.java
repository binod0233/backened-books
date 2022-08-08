package com.copenned.crm.dto.response.SingleResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalesManResponse {

    private int id;
    private String salesData;
    private int userId;
}
