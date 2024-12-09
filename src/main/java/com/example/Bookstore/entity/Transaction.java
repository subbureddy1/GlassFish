package com.example.Bookstore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trans_id")
    private Long id;
    private Long userId;
    private int quantity;
    private LocalDateTime transactionDate;
    @ManyToOne
    @JoinColumn(name = "book_id",referencedColumnName = "bookId")
private Book book;

}
