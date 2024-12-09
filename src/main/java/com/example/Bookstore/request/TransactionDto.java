package com.example.Bookstore.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransactionDto {
    private Long id;
    private Long userId;
    private int quantity;
    private LocalDateTime transDate;
    private BookDTo book;
}
