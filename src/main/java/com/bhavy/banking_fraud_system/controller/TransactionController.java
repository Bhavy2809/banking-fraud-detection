package com.bhavy.banking_fraud_system.controller;

import com.bhavy.banking_fraud_system.dto.TransactionRequest;
import com.bhavy.banking_fraud_system.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping
    public String createTransaction(
            @RequestBody TransactionRequest request) {

        transactionService.createTransaction(request);

        return "Transaction Saved";
    }
}