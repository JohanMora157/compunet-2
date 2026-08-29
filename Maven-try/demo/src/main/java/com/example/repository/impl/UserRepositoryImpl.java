package com.example.repository.impl;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;
import org.springframework.context.annotation.Scope;

import com.example.model.User;
import com.example.repository.IUserRepository;

@Repository
@Scope("singleton")
public class UserRepositoryImpl implements IUserRepository {

    private final List<User> users = new ArrayList<>();
    private int nextId = 1;

    public UserRepositoryImpl() {
        users.add(new User(nextId++, "Johan", "johan@gmail.com", "12345678"));
        users.add(new User(nextId++, "Santiago", "santiago@gmail.com", "12345678"));
    }

    @Override
    public List<User> findAll() {

        return users;

    }

    @Override
    public User save(User user) {

        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        user.setId(nextId);
        nextId++;

        users.add(user);

        return user;

    }

}
