package com.example.demo.dto;

public class BookDto {

    private String name;
    private int authorId;

    public BookDto(String name, int authorId) {
        this.name = name;
        this.authorId = authorId;
    }

    public BookDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
}
