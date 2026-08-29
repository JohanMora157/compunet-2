package com.example.repository;

import java.util.List;

import com.example.model.User;

public interface IUserRepository {

    List<User> findAll();

    User save(User user);

}
