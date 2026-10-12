package com.example.demo.repository;

import com.example.demo.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPermissionRepository extends JpaRepository<Permission, Integer> {

    // Query method con JOIN para obtener los permisos de un usuario por su ID
    List<Permission> findByRolePermissions_Role_Users_Id(Integer userId);
}
