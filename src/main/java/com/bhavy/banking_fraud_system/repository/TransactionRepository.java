package com.bhavy.banking_fraud_system.repository;

import com.bhavy.banking_fraud_system.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository
        extends JpaRepository<Transaction, Long> {
}