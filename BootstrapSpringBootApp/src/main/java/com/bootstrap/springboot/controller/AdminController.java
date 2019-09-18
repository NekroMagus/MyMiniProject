package com.bootstrap.springboot.controller;

import com.bootstrap.springboot.domain.Role;
import com.bootstrap.springboot.domain.User;
import com.bootstrap.springboot.service.RoleService;
import com.bootstrap.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping
    public String getAdminPage(Model model)
    {
        model.addAttribute("role", roleService.findAllRoles());
        model.addAttribute("users", userService.findAllUsers());
        model.addAttribute("us", new User());
        return "admin";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user")User user) {
        userService.addUser(user);
        return "redirect:/admin";
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute("user")User user) {
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "redirect:/admin";
    }

}
