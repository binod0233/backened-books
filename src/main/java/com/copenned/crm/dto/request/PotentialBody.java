package com.copenned.crm.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PotentialBody {
        private String potential;
        private String leadName;
        private String teamLead;
        private int leadId;
        private String remarks = "Just won";
        private String clientManager;



}
