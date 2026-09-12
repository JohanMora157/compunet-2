package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.IUserService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @GetMapping("/findall")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/findbyid")
    public Optional<User> findByIdParam() {
        return userService.findById(1);
    }

    @GetMapping("/findbyrolename")
    public List<User> getMethodName(@RequestParam String role) {
        return userService.findByRoleName(role);
    }

    // OPCIÓN 1: Usando @RequestParam (Query Param)
    // Ejemplo de URL: GET http://localhost:8081/compu2/users/findbyid?id=1

    /*
     * @GetMapping("/findbyid")
     * public Optional<User> findByIdParam(@RequestParam int id) {
     * return userService.findById(id);
     * }
     */

    // OPCIÓN 2: Usando @PathVariable (Path Param / Ruta REST estándar)
    // Ejemplo de URL: GET http://localhost:8081/compu2/users/1
    @GetMapping("/{id}")
    public Optional<User> findByIdPath(@PathVariable int id) {
        return userService.findById(id);
    }

}
