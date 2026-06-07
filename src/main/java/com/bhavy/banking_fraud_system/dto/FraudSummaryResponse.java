package com.bhavy.banking_fraud_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FraudSummaryResponse {

    private long totalTransactions;

    private long fraudTransactions;

    private double fraudPercentage;

    private long todayFrauds;

    private long weekFrauds;

    private long monthFrauds;
}