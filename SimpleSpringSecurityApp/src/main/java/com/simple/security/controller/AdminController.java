package com.simple.security.controller;

import com.simple.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @Autowired
    UserService userService;

    @GetMapping("/admin")
    public String adminPage(ModelMap model) {
        model.addAttribute("users",userService.findAll());
        return "admin";
    }
}
