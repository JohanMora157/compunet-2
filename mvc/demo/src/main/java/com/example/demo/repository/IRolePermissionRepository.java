package com.example.demo.repository;

import com.example.demo.model.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRolePermissionRepository extends JpaRepository<RolePermission, Integer> {
}
