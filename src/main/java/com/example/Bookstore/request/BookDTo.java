package com.example.Bookstore.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDTo {
    private Long bookId;
    private String title;
    private long price;
}
