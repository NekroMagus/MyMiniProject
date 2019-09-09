package com.simple.springmvc.controller;

import com.simple.springmvc.model.Role;
import com.simple.springmvc.model.User;
import com.simple.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "admin";
    }

    @PostMapping("/addUser")
    public String addUser(User user) {
        userService.addUser(user);
        return "redirect:/admin";
    }

    @RequestMapping(value = "{id}/delete", method = RequestMethod.GET)
    public String deleteUser(@PathVariable long id) {
        userService.deleteUserById(id);
        return "redirect:/admin";
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute("user") User user) {
        User userUpd = userService.findUserById(user.getId());
        userUpd.setLogin(user.getLogin());
        userUpd.setPassword(user.getPassword());
        userUpd.setRole(Role.ADMIN);
        userService.updateUser(userUpd);
        return "redirect:/admin";
    }
}
