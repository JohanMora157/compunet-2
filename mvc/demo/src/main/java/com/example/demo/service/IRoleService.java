package com.example.demo.service;

import com.example.demo.model.Role;

import java.util.List;
import java.util.Optional;

public interface IRoleService {
    Role create(Role role);
    List<Role> findAll();
    Optional<Role> findById(Integer id);
    Role update(Integer id, Role role);
    void deleteById(Integer id);
}
