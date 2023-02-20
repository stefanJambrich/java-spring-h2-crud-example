package com.example.demo.service.author;

import com.example.demo.entity.Author;

import java.util.List;

public interface IAuthorService {

    List<Author> getAllAuthors();

    Author getAuthor(int id);

    void createAuthor(Author author);

    void deleteAuthor(int id);
}
