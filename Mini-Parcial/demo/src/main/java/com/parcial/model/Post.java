package com.parcial.model;

public class Post {

    private int id;
    private String title;
    private String content;
    private Author author;

    public Post(int id, String title, String content) {

        this.id = id;
        this.title = title;
        this.content = content;
        this.author = null;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Author getAuthor() {
        return author;
    }

    public Post setAuthor(Author author) {
        this.author = author;
        return this;
    }

}
