package com.example.demo.service.book;

import com.example.demo.entity.Book;

import java.util.List;

public interface IBookService {

    List<Book> getAllBooks();
    Book getBook(int id);
    void createBook(Book book);
    void deleteBook(int id);
}
