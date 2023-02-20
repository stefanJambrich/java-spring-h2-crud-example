package com.example.demo.controller;

import com.example.demo.dto.AuthorDto;
import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.service.author.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("api/v1/author")
public class AuthorController {

    private final AuthorRepository authorRepository;
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorRepository authorRepository, AuthorService authorService) {
        this.authorRepository = authorRepository;
        this.authorService = authorService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Author> getAuthor(@RequestBody int id) {
        return ResponseEntity.status(200).body(authorService.getAuthor(id));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Author>> getAuthors() {
        return ResponseEntity.status(200).body(authorService.getAllAuthors());
    }

    @RequestMapping(method = RequestMethod.POST, path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createBook(@RequestBody AuthorDto author) {
        Author author1 = new Author();
        author1.setAuthorName(author.getName());

        authorRepository.save(author1);
        return ResponseEntity.status(200).body("Author created successfully");
    }
}