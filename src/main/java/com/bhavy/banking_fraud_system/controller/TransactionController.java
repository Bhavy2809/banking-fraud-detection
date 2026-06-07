package com.bhavy.banking_fraud_system.controller;
import java.util.List;
import com.bhavy.banking_fraud_system.entity.Transaction;
import com.bhavy.banking_fraud_system.dto.TransactionRequest;
import com.bhavy.banking_fraud_system.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.bhavy.banking_fraud_system.dto.DashboardResponse;import com.bhavy.banking_fraud_system.dto.FraudSummaryResponse;
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
    @GetMapping("/today")
    public List<Transaction> getTodayTransactions() {

        return transactionService
                .getTodayTransactions();
    }
    @GetMapping("/stats/fraud-count")
    public long getFraudTransactionsCount() {

        return transactionService
                .getFraudTransactionsCount();
    }
    @GetMapping("/dashboard")
    public DashboardResponse getDashboardStats() {

        return transactionService
                .getDashboardStats();
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
    }@GetMapping("/week")
    public List<Transaction> getWeekTransactions() {

        return transactionService
                .getWeekTransactions();
    }@GetMapping("/month")
    public List<Transaction> getMonthTransactions() {

        return transactionService
                .getMonthTransactions();
    }@GetMapping("/fraud/today")
    public long getTodayFraudCount() {

        return transactionService
                .getTodayFraudCount();
    }@GetMapping("/fraud/week")
    public long getWeekFraudCount() {

        return transactionService
                .getWeekFraudCount();
    }@GetMapping("/fraud/month")
    public long getMonthFraudCount() {

        return transactionService
                .getMonthFraudCount();
    }@GetMapping("/recent-frauds")
    public List<Transaction> getRecentFraudTransactions() {

        return transactionService
                .getRecentFraudTransactions();
    }@GetMapping("/fraud-summary")
    public FraudSummaryResponse getFraudSummary() {

        return transactionService.getFraudSummary();
    }
}