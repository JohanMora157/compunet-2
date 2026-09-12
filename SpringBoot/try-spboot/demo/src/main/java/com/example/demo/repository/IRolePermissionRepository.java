package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.RolePermission;

@Repository
public interface IRolePermissionRepository extends JpaRepository<RolePermission, Integer> {
    List<RolePermission> findByRoleId(int roleId);
    List<RolePermission> findByPermissionId(int permissionId);
}
