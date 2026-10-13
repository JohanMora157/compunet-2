package com.example.demo.service.impl;

import com.example.demo.exceptions.BadRequestException;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.Permission;
import com.example.demo.repository.IPermissionRepository;
import com.example.demo.service.IPermissionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements IPermissionService {

    private final IPermissionRepository permissionRepository;

    @Override
    public Permission create(Permission permission) {
        log.info("Creating permission: {}", permission);
        if (permission == null) {
            throw new BadRequestException("Permission cannot be null");
        }
        if (permission.getName() == null || permission.getName().trim().isEmpty()) {
            throw new BadRequestException("Permission name cannot be null or empty");
        }
        return permissionRepository.save(permission);
    }

    @Override
    public List<Permission> findAll() {
        log.info("Fetching all permissions");
        return permissionRepository.findAll();
    }

    @Override
    public Optional<Permission> findById(Integer id) {
        log.info("Finding permission by id: {}", id);
        return permissionRepository.findById(id);
    }

    @Override
    public Permission update(Integer id, Permission permission) {
        log.info("Updating permission id: {} with data: {}", id, permission);
        if (id == null) {
            throw new BadRequestException("Permission id cannot be null");
        }
        if (permission == null) {
            throw new BadRequestException("Permission cannot be null");
        }
        Permission existingPermission = permissionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Permission not found with id: " + id));

        if (permission.getName() != null && !permission.getName().trim().isEmpty()) {
            existingPermission.setName(permission.getName());
        }
        if (permission.getDescription() != null) {
            existingPermission.setDescription(permission.getDescription());
        }

        return permissionRepository.save(existingPermission);
    }

    @Override
    public void deleteById(Integer id) {
        log.info("Deleting permission by id: {}", id);
        if (id == null) {
            throw new BadRequestException("Permission id cannot be null");
        }
        if (!permissionRepository.existsById(id)) {
            throw new ResourceNotFoundException("Permission not found with id: " + id);
        }
        permissionRepository.deleteById(id);
    }
}
