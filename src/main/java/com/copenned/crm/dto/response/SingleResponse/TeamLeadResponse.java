package com.copenned.crm.dto.response.SingleResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamLeadResponse {
    private int id;
    private int salesmanId;
    private int userId;

}
