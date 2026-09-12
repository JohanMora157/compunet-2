package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Permission;
import com.example.demo.service.IPermissionService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/permissions")
@RequiredArgsConstructor
public class PermissionController {

    private final IPermissionService permissionService;

    @GetMapping("/findpermissionsbyname")
    public List<Permission> getMethodName(@RequestParam String name) {
        return permissionService.findPermissionsByName(name);
    }

}