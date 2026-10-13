package com.example.demo.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/mvc/auth")
public class AuthMVCController {

    @GetMapping("/login")
    public String showLoginPage(
            @RequestParam(required = false) String error,
            @RequestParam(required = false) String logout,
            Model model) {

        if (error != null) {
            model.addAttribute(
                "errorMessage",
                "Correo o contraseña incorrectos"
            );
        }

        if (logout != null) {
            model.addAttribute(
                "logoutMessage",
                "Sesión cerrada correctamente"
            );
        }

        return "auth/login";
    }
}
