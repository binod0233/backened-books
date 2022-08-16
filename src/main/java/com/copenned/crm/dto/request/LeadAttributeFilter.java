package com.copenned.crm.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class LeadAttributeFilter {
        private String leadName;
        private String serviceType;
        private String potential;
        private Date date1;
        private Double amount;
        private String teamLead;
        private String ClientManager;


    }

