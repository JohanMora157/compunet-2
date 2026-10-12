package com.example.demo.service;

import com.example.demo.model.Permission;

import java.util.List;
import java.util.Optional;

public interface IPermissionService {
    Permission create(Permission permission);
    List<Permission> findAll();
    Optional<Permission> findById(Integer id);
    Permission update(Integer id, Permission permission);
    void deleteById(Integer id);
}
