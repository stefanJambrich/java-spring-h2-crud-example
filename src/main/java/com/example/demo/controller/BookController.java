package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("api/v1/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> getBook(@RequestBody int id) {
        return ResponseEntity.status(200).body(bookService.getBook(id));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Book>> getBooks() {
        return ResponseEntity.status(200).body(bookService.getAllBooks());
    }

    @RequestMapping(method = RequestMethod.POST, path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createBook(@RequestBody Book book) {
        bookService.createBook(book);
        return ResponseEntity.status(200).body("Book created successfully");
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteBook(@RequestBody int id) {
        bookService.deleteBook(id);
        return ResponseEntity.status(200).body("Book deleted successfully");
    }
}
