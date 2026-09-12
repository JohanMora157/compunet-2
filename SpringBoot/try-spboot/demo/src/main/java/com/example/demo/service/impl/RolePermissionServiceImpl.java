package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.RolePermission;
import com.example.demo.repository.IRolePermissionRepository;
import com.example.demo.service.IRolePermissionService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RolePermissionServiceImpl implements IRolePermissionService {

    private final IRolePermissionRepository rolePermissionRepository;

    @Override
    public List<RolePermission> findAll() {
        return rolePermissionRepository.findAll();
    }

    @Override
    public Optional<RolePermission> findById(Integer id) {
        return rolePermissionRepository.findById(id);
    }

    @Override
    public RolePermission save(RolePermission rolePermission) {
        return rolePermissionRepository.save(rolePermission);
    }

    @Override
    public void deleteById(Integer id) {
        rolePermissionRepository.deleteById(id);
    }

    @Override
    public List<RolePermission> findByRoleId(int roleId) {
        return rolePermissionRepository.findByRoleId(roleId);
    }

    @Override
    public List<RolePermission> findByPermissionId(int permissionId) {
        return rolePermissionRepository.findByPermissionId(permissionId);
    }
}
