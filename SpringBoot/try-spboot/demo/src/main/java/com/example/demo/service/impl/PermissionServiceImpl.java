package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Permission;
import com.example.demo.repository.IPermissionRepository;
import com.example.demo.service.IPermissionService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements IPermissionService {

    private final IPermissionRepository permissionRepository;

    @Override
    public List<Permission> findAll() {
        return permissionRepository.findAll();
    }

    @Override
    public Optional<Permission> findById(Integer id) {
        return permissionRepository.findById(id);
    }

    @Override
    public Permission save(Permission permission) {
        return permissionRepository.save(permission);
    }

    @Override
    public void deleteById(Integer id) {
        permissionRepository.deleteById(id);
    }


      @Override
    public List<Permission> findByRolePermissions_Role_Name(String roleName) {
        return permissionRepository.findByRolePermissions_Role_Name(roleName);
    }

    
}
