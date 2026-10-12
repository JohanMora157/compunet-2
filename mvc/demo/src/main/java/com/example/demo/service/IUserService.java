package com.example.demo.service;

import com.example.demo.exceptions.TransactionTestException;
import com.example.demo.model.User;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    User create(User user, Integer roleId);
    Page<User> findAll(int page, int size, String sortBy, String direction);
    List<User> findAll();
    Optional<User> findById(Integer id);
    User update(Integer id, User user, Integer roleId);
    void deleteById(Integer id);
    List<User> saveAllUsers(List<User> users) throws TransactionTestException;
}
