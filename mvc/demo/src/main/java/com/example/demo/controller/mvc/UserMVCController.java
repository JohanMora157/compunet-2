package com.example.demo.controller.mvc;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.*;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.User;
import com.example.demo.service.IUserService;
import com.example.demo.service.IRoleService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;







@Controller
@RequestMapping("/mvc/users")
@RequiredArgsConstructor 
public class UserMVCController {
    
private final IUserService userService;
private final IRoleService roleService;


@GetMapping({"", "/", "/list"})
    public String getAll(Model model) {

        model.addAttribute(
            "users",
            userService.findAll()
        );

        Authentication auth =
            SecurityContextHolder.getContext().getAuthentication();

        model.addAttribute(
            "username",
            auth.getName()
        );

        boolean canWrite = auth.getAuthorities()
            .stream()
            .anyMatch(a ->
                a.getAuthority().equals("USER_WRITE") ||
                a.getAuthority().equals("ROLE_ADMIN")
            );

        model.addAttribute("canWrite", canWrite);

        return "users/list";
    }

@GetMapping("/add")
public String addUser(Model model) {

    User user = new User();

    model.addAttribute("user", user);
    model.addAttribute("roles",roleService.findAll());


    return "users/add";
}


@PostMapping("/add")
public String postMethodName(@ModelAttribute User user,
        @RequestParam (required = false)Integer roleId) {


            user.setCreatedAt(new Timestamp(System.currentTimeMillis()));

            userService.create(user, roleId);
    
    return "redirect:/mvc/users";
}

@GetMapping("/edit/{id}")
public String editUser(@PathVariable Integer id,
        Model model) {

User user = userService.findById(id).orElse(null);

model.addAttribute("actualUser", user);
    model.addAttribute("roles",roleService.findAll());


    return "users/edit";
}

@PutMapping("/edit/{id}")
public String editUser(
        @PathVariable Integer id,
        @ModelAttribute User user,
        @RequestParam(required = false) Integer roleId) {

    userService.update(id, user, roleId);

    return "redirect:/mvc/users";
}

@DeleteMapping("/delete/{id}")
public String deleteUser(@PathVariable Integer id) {
    userService.deleteById(id);
    return "redirect:/mvc/users";
}

}
