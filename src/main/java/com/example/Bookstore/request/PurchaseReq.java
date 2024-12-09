package com.example.Bookstore.request;

import lombok.Data;

@Data
public class PurchaseReq {
    private Long bookId;
    private Long userId;
    private int quantity;
}
