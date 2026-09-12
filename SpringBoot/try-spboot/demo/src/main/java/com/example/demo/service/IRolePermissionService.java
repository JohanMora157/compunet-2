package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.RolePermission;

public interface IRolePermissionService {
    List<RolePermission> findAll();
    Optional<RolePermission> findById(Integer id);
    RolePermission save(RolePermission rolePermission);
    void deleteById(Integer id);
    List<RolePermission> findByRoleId(int roleId);
    List<RolePermission> findByPermissionId(int permissionId);
}
