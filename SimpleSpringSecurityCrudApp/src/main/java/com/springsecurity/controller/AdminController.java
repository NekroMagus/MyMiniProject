package com.springsecurity.controller;

import com.springsecurity.model.User;
import com.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String printUsers(ModelMap model){
        model.addAttribute("users",userService.findAllUsers());
        return "/admin";
    }

    @PostMapping("addUser")
    public String addUser(@RequestParam String login, @RequestParam String password){
        userService.addUser(new User(login, password));
        return "redirect:/admin";
    }

    @RequestMapping(value = "{id}/delete" , method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") long id){
        userService.deleteUserById(id);
        return "redirect:/admin";
    }

    @PostMapping("updateUser")
    public String updateUser(@ModelAttribute("user") User user){
        User editUser = userService.findUserById(user.getId());
        editUser.setLogin(user.getLogin());
        editUser.setPassword(user.getPassword());
        userService.updateUser(editUser);
        return "redirect:/admin";
    }
}
