package com.springboot.controller;

import com.springboot.domain.Role;
import com.springboot.domain.User;
import com.springboot.service.RoleService;
import com.springboot.service.UserService;
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
        model.addAttribute("users", userService.findAll());
        return "admin";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam String login, @RequestParam String email,
                          @RequestParam String password, @RequestParam(value = "roles") String[] roles) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setEmail(email);
        Set<Role> roleUser = new HashSet<>();
        for (int i = 0; i < roles.length; i++) {
            roleUser.add(roleService.findRoleByName(roles[i]));
        }
        user.setRoles(roleUser);
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @PostMapping("/updateUser")
    public String updateUser(@RequestParam Long id,
                             @RequestParam String login, @RequestParam String email,
                             @RequestParam String password, @RequestParam(value = "roles") String[] roles) {
        User user = userService.findById(id);
        user.setEmail(email);
        user.setLogin(login);
        user.setPassword(password);
        Set<Role> roleUser = new HashSet<>();
        for (int i = 0; i < roles.length; i++) {
            roleUser.add(roleService.findRoleByName(roles[i]));
        }
        user.setRoles(roleUser);
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return "redirect:/admin";
    }

}
