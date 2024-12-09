package com.example.Bookstore.service;

import com.example.Bookstore.entity.Book;
import com.example.Bookstore.entity.Transaction;
import com.example.Bookstore.repositoy.BookRepo;
import com.example.Bookstore.repositoy.TransactionRepo;
import com.example.Bookstore.request.BookDTo;
import com.example.Bookstore.request.TransactionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepo transactionRepo;
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private BookService bookService;


    public List<TransactionDto> getTransactionsByUser(Long userId) {
        // Fetch the transactions for the given userId
        List<Transaction> transactions = transactionRepo.findByUserId(userId);

        // Convert each transaction into TransactionDTO
        return transactions.stream().map(transaction -> {
            // Create BookDTO for each transaction
            BookDTo bookDTO = new BookDTo(
                    transaction.getBook().getBookId(),
                    transaction.getBook().getTitle(),
                    transaction.getBook().getPrice()
            );

            // Return a TransactionDTO with BookDTO
            return new TransactionDto(
                    transaction.getId(),
                    transaction.getUserId(),
                    transaction.getQuantity(),
                    transaction.getTransactionDate(),
                    bookDTO
            );
        }).collect(Collectors.toList());
    }
}