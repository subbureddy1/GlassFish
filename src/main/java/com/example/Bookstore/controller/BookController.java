package com.example.Bookstore.controller;

import com.example.Bookstore.entity.Book;
import com.example.Bookstore.request.PurchaseReq;
import com.example.Bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/saveBook")
    public Book saveBook(@RequestBody Book book) {
        Book book1 = bookService.saveBook(book);
        return book1;
    }

    @PostMapping("/purchase")
    public String processPurchase(@RequestBody PurchaseReq purchaseReq) {
        try {
            bookService.processPurchase(purchaseReq.getBookId(),purchaseReq.getUserId(),purchaseReq.getQuantity());
            return "Purchase successful!";
        } catch (RuntimeException e) {
            return "Error: " + e.getMessage();
        }
    }
        @GetMapping("/getAll")
        public List<Book> getAll () {
            List<Book> books = bookService.getAll();
            return books;
        }
        @GetMapping("getById/{id}")
        public Book getById (@PathVariable Long id){
            return bookService.getById(id).orElse(null);
        }
    }

