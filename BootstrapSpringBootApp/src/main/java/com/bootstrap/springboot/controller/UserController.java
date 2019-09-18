package com.bootstrap.springboot.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public String getUserPage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Set<GrantedAuthority> roles = new HashSet<>();
        for (GrantedAuthority ga : auth.getAuthorities()) {
            roles.add(new SimpleGrantedAuthority(ga.getAuthority()));
        }
        model.addAttribute("login", auth.getName());
        model.addAttribute("role", roles);
        return "user";
    }
}
