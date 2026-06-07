package com.bhavy.banking_fraud_system.service;

import com.bhavy.banking_fraud_system.dto.DashboardResponse;
import com.bhavy.banking_fraud_system.dto.FraudSummaryResponse;
import com.bhavy.banking_fraud_system.dto.TransactionRequest;
import com.bhavy.banking_fraud_system.entity.Transaction;

import java.util.List;

public interface TransactionService {

    void createTransaction(TransactionRequest request);

    List<Transaction> getAllTransactions();

    List<Transaction> getFraudTransactions();

    List<Transaction> getTransactionsByAccount(
            String accountNumber);

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