package com.springcrud.controller;

import com.springcrud.model.User;
import com.springcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String printUsers(ModelMap model) {
        model.addAttribute("users", userService.findAllUsers());
        return "/users";
    }


    @PostMapping("addUser")
    public String addUser(@RequestParam String login,@RequestParam String password) {
        User user = new User(login,password);
        userService.addUser(user);
        return "redirect:/users";
    }

    @PostMapping("delUser")
    public String delUser(@RequestParam long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @PostMapping("updateUser")
    public String updateUser(@RequestParam long id, @RequestParam String login, @RequestParam String password){
        User user = userService.findUserById(id);
        user.setLogin(login);
        user.setPassword(password);
        userService.updateUser(user);
        return "redirect:/users";
    }
}
