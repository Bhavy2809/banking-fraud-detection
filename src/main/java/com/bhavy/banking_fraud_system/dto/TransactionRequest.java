package com.bhavy.banking_fraud_system.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionRequest {

    private String senderAccount;

    private String receiverAccount;

    private Double amount;
}