package com.example.Bookstore.repositoy;

import com.example.Bookstore.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction,Long> {
    List<Transaction> findByUserId(Long userId);
}
