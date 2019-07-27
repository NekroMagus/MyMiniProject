package com.springcrud.controller;

import com.springcrud.model.User;
import com.springcrud.service.SpringUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private SpringUserService userService;

    @Autowired
    public void setUserService(SpringUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String printUsers(ModelMap model) {
        model.addAttribute("users", userService.findAllUsers());
        return "/users";
    }


    @PostMapping("addUser")
    public String addUser(@RequestParam String login, @RequestParam String password) {
        User user = new User(login, password);
        userService.addUser(user);
        return "redirect:/users";
    }

    @RequestMapping(value = "{id}/delete", method = RequestMethod.GET)
    public String delUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @PostMapping("updateUser")
    public String updateUser(@ModelAttribute("user") User user) {
        User editUser = userService.findUserById(user.getId());
        editUser.setLogin(user.getLogin());
        editUser.setPassword(user.getPassword());
        userService.updateUser(editUser);
        return "redirect:/users";
    }
}
