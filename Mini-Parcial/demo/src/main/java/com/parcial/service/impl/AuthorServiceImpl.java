package com.parcial.service.impl;

import java.util.List;

import com.parcial.model.Author;
import com.parcial.repository.IAuthorRepository;
import com.parcial.service.IAuthorService;

public class AuthorServiceImpl implements IAuthorService {

    private IAuthorRepository authorRepository;

    public AuthorServiceImpl(IAuthorRepository authorRepository) {

        this.authorRepository = authorRepository;

    }

    @Override
    public List<Author> listAll() {
        return authorRepository.listAll();
    }

    @Override
    public Author saveAuthor(Author author) {

        return authorRepository.saveAuthor(author);
    }

    @Override
    public Author searchAuthor(int id) {
        return authorRepository.searchAuthor(id);
    }
}
