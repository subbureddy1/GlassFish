package com.example.Bookstore.controller;

import com.example.Bookstore.entity.Transaction;
import com.example.Bookstore.request.TransactionDto;
import com.example.Bookstore.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

        @GetMapping("/transactions/user/{userId}")
        public List<TransactionDto> getTransactionsByUser(@PathVariable Long userId) {
            return transactionService.getTransactionsByUser(userId);
        }
}
