package com.bhavy.banking_fraud_system.service;
import com.bhavy.banking_fraud_system.dto.DashboardResponse;
import com.bhavy.banking_fraud_system.dto.TransactionRequest;
import java.util.List;import com.bhavy.banking_fraud_system.dto.FraudSummaryResponse;
import com.bhavy.banking_fraud_system.entity.Transaction;import org.springframework.data.domain.PageRequest;
public interface TransactionService {

    void createTransaction(TransactionRequest request);

    List<Transaction> getAllTransactions();

    List<Transaction> getFraudTransactions();

    long getTotalTransactions();
    List<Transaction> getTodayTransactions();
    List<Transaction> getTopRiskTransactions();
    List<Transaction> getWeekTransactions();
    long getTodayFraudCount();
    FraudSummaryResponse getFraudSummary();
    long getWeekFraudCount();
    List<Transaction> getRecentFraudTransactions();
    long getMonthFraudCount();
    List<Transaction> getMonthTransactions();
    long getFraudTransactionsCount();
    DashboardResponse getDashboardStats();
    double getFraudPercentage();
}