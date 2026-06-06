package com.bhavy.banking_fraud_system.controller;
import java.util.List;
import com.bhavy.banking_fraud_system.entity.Transaction;
import com.bhavy.banking_fraud_system.dto.TransactionRequest;
import com.bhavy.banking_fraud_system.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;
    @GetMapping("/stats/total")
    public long getTotalTransactions() {

        return transactionService
                .getTotalTransactions();
    }

    @GetMapping("/stats/fraud-count")
    public long getFraudTransactionsCount() {

        return transactionService
                .getFraudTransactionsCount();
    }

    @GetMapping("/stats/fraud-percentage")
    public double getFraudPercentage() {

        return transactionService
                .getFraudPercentage();
    }
    @PostMapping
    public String createTransaction(
            @RequestBody TransactionRequest request) {

        transactionService.createTransaction(request);

        return "Transaction Saved";
    }
    @GetMapping("/fraud")
    public List<Transaction> getFraudTransactions() {

        return transactionService
                .getFraudTransactions();
    }
    @GetMapping
    public List<Transaction> getAllTransactions() {

        return transactionService.getAllTransactions();
    }
}