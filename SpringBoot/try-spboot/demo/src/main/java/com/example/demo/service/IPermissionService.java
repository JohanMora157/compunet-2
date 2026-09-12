package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Permission;

public interface IPermissionService {
    List<Permission> findAll();

    Optional<Permission> findById(Integer id);

    Permission save(Permission permission);

    void deleteById(Integer id);

List<Permission> findByRolePermissions_Role_Name(String roleName);
}
