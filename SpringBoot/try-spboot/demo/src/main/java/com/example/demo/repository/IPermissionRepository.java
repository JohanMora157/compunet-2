package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Permission;

@Repository
public interface IPermissionRepository extends JpaRepository<Permission, Integer> {

    List<Permission> findByName(String name);

    List<Permission> findByRolePermissions_Role_Name(String roleName);



    /*
    BUSCAR LOS PERMISOS DE UN ROL

    permission --> RolePermissions --> Role --> name
    
    
    
    
    
    */

}
