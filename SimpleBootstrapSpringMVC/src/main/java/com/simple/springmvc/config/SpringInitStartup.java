package com.simple.springmvc.config;

import com.simple.springmvc.model.Role;
import com.simple.springmvc.model.User;
import com.simple.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class SpringInitStartup {

    @Autowired
    private UserService userService;

    @EventListener(ContextRefreshedEvent.class)
    void contextRefreshedEvent() {
        User user = userService.findUserByLogin("admin");
        if (user == null) {
            user = new User("admin", "admin");
            user.setRole(Role.ADMIN);
            userService.addUser(user);
        }
    }
}
