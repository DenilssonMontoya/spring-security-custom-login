package com.denilsson.springsecurity.customlogin.controller;


import com.denilsson.springsecurity.customlogin.model.CustomUser;
import com.denilsson.springsecurity.customlogin.service.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    public CustomUserService customUserService;

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }

    @GetMapping("/signup")
    public String register() {
        return "auth/signup";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute CustomUser user) {
        customUserService.saveUser(user);
        return "redirect:/auth/login?signedUp=true";
    }
    
}
