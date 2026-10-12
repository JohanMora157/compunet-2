package com.example.demo.controller.mvc;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.User;
import com.example.demo.repository.IRoleRepository;
import com.example.demo.repository.IUserRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;






@Controller
@RequestMapping("/mvc/users")
@RequiredArgsConstructor 
public class UserMVCController {
    
private final IUserRepository userRepository;
private final IRoleRepository roleRepository;


@GetMapping("/list")
public String getAllUsers(Model model) {

List<User> users =userRepository.findAll();



model.addAttribute("users",users);

return "users/list";

}

@GetMapping("/add")
public String addUser(Model model) {

    User user = new User();

    model.addAttribute("user", user);
    model.addAttribute("roles",roleRepository.findAll());


    return "users/add";
}




}
