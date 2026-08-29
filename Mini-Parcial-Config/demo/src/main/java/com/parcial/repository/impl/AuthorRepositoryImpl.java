package com.parcial.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.parcial.model.Author;
import com.parcial.repository.IAuthorRepository;

public class AuthorRepositoryImpl implements IAuthorRepository {

    private List<Author> authors = new ArrayList<>();
    private int idCounter = 1;

    @Override
    public void init() {

        authors.clear();
        saveAuthor(new Author(0, "Johan Mora"));
        saveAuthor(new Author(0, "Juan Aponza"));
        saveAuthor(new Author(0, "Juan Fajardo"));
        saveAuthor(new Author(0, "Juan Cubillos"));
        saveAuthor(new Author(0, "Juan Zuniga"));
        saveAuthor(new Author(0, "Santiago Florez"));

    }

    @Override
    public List<Author> listAll() {

        return authors;

    }

    @Override
    public Author saveAuthor(Author author) {

        if (author == null) {
            return null;
        } else {
            author.setId(idCounter++);

            authors.add(author);
            return author;
        }

    }

    @Override
    public Author searchAuthor(int id) {
        for (Author author : authors) {

            if (author.getId() == id) {
                return author;
            }
        }

        return null;

    }

}
