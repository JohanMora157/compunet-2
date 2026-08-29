package com.parcial.repository;

import com.parcial.model.*;
import java.util.*;

public interface IAuthorRepository {

    void init();

    List<Author> listAll();

    Author saveAuthor(Author author);

    Author searchAuthor(int id);

}