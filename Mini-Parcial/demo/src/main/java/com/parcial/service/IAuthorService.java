package com.parcial.service;

import java.util.List;

import com.parcial.model.Author;

public interface IAuthorService {

    List<Author> listAll();

    Author saveAuthor(Author author);

    Author searchAuthor(int id);

}
