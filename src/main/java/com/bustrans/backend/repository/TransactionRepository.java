package com.bustrans.backend.repository;

import com.bustrans.backend.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    // Interface par défaut pour la gestion des transactions
}
