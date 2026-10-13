package com.example.demo.service.impl;

import static java.rmi.server.LogStream.log;

import com.example.demo.exceptions.BadRequestException;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.Role;
import com.example.demo.repository.IRoleRepository;
import com.example.demo.service.IRoleService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements IRoleService {

    private final IRoleRepository roleRepository;

    @Override
    public Role create(Role role) {
        log.info("Creating role: {}", role);
        if (role == null) {
            throw new BadRequestException("Role cannot be null");
        }
        if (role.getName() == null || role.getName().trim().isEmpty()) {
            throw new BadRequestException("Role name cannot be null or empty");
        }
        return roleRepository.save(role);
    }

    @Override
    public List<Role> findAll() {
        log.info("Fetching all roles");
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> findById(Integer id) {
        log.info("Finding role by id: {}", id);
        return roleRepository.findById(id);
    }

    @Override
    public Role update(Integer id, Role role) {
        log.info("Updating role id: {} with data: {}", id, role);
        if (id == null) {
            throw new BadRequestException("Role id cannot be null");
        }
        if (role == null) {
            throw new BadRequestException("Role cannot be null");
        }
        Role existingRole = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found with id: " + id));

        if (role.getName() != null && !role.getName().trim().isEmpty()) {
            existingRole.setName(role.getName());
        }
        return roleRepository.save(existingRole);
    }

    @Override
    public void deleteById(Integer id) {
        log.info("Deleting role by id: {}", id);
        if (id == null) {
            throw new BadRequestException("Role id cannot be null");
        }
        if (!roleRepository.existsById(id)) {
            throw new ResourceNotFoundException("Role not found with id: " + id);
        }
        roleRepository.deleteById(id);
    }
}
