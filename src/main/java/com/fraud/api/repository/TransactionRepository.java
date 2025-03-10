package com.fraud.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fraud.api.model.Transaction;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByUserId(Long userId);
}
