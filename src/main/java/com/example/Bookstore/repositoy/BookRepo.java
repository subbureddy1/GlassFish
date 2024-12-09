package com.example.Bookstore.repositoy;

import com.example.Bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book,Long> {
}
