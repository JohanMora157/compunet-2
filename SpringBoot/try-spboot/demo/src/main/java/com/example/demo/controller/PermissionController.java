package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Permission;
import com.example.demo.service.IPermissionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/permissions")
@RequiredArgsConstructor
public class PermissionController {

    private final IPermissionService permissionService;

    
     @GetMapping("/findPermissionUser")
    public List<Permission> fff(@RequestParam String roleName) {
        return permissionService.findByRolePermissions_Role_Name(roleName);
    }
}