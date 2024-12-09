package com.example.Bookstore.service;


import com.example.Bookstore.entity.Book;
import com.example.Bookstore.entity.Transaction;
import com.example.Bookstore.repositoy.BookRepo;
import com.example.Bookstore.repositoy.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;
@Autowired
    private TransactionRepo transactionRepo;
    public Book saveBook(Book book) {
        return bookRepo.save(book);
    }

    public List<Book> getAll() {
        return bookRepo.findAll();
    }

    public Optional<Book> getById(Long id) {
        return bookRepo.findById(id);
    }

    public void processPurchase(Long bookId, Long userId, int quantity) {
        Book book = bookRepo.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        // Step 2: Check if the stock is sufficient
        if (book.getStock() < quantity) {
            throw new RuntimeException("Not enough stock available");
        }

        // Step 3: Create a new transaction record
        Transaction transaction = new Transaction();
        transaction.setUserId(userId);
        transaction.setBook(book);
        transaction.setQuantity(quantity);
        transaction.setTransactionDate(LocalDateTime.now());

        // Save the transaction in the database
        transactionRepo.save(transaction);

        // Step 4: Update the stock in the book table
        book.setStock(book.getStock() - quantity);
        bookRepo.save(book);
    }
    }

