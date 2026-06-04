package com.bhavy.banking_fraud_system.repository;

import com.bhavy.banking_fraud_system.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.stereotype.Repository;
@Repository
public interface TransactionRepository
        extends JpaRepository<Transaction, Long> {

    List<Transaction> findByIsFraudTrue();
}