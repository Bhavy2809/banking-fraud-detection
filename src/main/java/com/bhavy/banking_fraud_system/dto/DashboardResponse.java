package com.bhavy.banking_fraud_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DashboardResponse {

    private long totalTransactions;

    private long fraudTransactions;

    private double fraudPercentage;
}