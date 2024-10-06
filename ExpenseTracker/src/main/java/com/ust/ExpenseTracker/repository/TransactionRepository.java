package com.ust.ExpenseTracker.repository;

import com.ust.ExpenseTracker.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByDate(LocalDate date);
    List<Transaction> findByDateBetween(LocalDate startDate, LocalDate endDate);
    List<Transaction> findByCategoryAndDate(String category, LocalDate date);
}