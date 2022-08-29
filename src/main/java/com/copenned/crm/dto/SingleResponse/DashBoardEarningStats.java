package com.copenned.crm.dto.SingleResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DashBoardEarningStats {
    private Double totalEarning;
    private Double change;
}