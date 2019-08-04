package com.simple.security.controller;

import com.simple.security.model.User;
import com.simple.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserService userService;

    @GetMapping
    public String adminPage(ModelMap model) {
        model.addAttribute("users", userService.findAll());
        return "/admin";
    }

    @PostMapping("addUser")
    public String addUser(@RequestParam String login, @RequestParam String password) {
        userService.addUser(new User(login, password));
        return "redirect:/admin";
    }

    @PostMapping("updateUser")
    public String updateUser(@ModelAttribute("user") User user) {
        User updUser = userService.findUserById(user.getId());
        updUser.setLogin(user.getLogin());
        updUser.setPassword(user.getPassword());
        userService.updateUser(updUser);
        return "redirect:/admin";
    }

    @RequestMapping(value = "{id}/delete", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }
}
