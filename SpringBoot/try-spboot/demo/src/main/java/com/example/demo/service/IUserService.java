package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.User;

public interface IUserService {
    List<User> findAll();
    Optional<User> findById(Integer id);
    User save(User user);
    void deleteById(Integer id);
    Optional<User> findByEmail(String email);
    List<User> findByRoleId(int roleId);
        List<User> findByRoleName(String roleName);

}
