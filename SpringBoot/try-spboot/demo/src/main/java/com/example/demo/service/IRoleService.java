package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Role;

public interface IRoleService {
    List<Role> findAll();
    Optional<Role> findById(Integer id);
    Role save(Role role);
    void deleteById(Integer id);
    Optional<Role> findByName(String name);
}
