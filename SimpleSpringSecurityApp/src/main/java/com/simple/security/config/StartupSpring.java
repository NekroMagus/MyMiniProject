package com.simple.security.config;

import com.simple.security.model.Role;
import com.simple.security.model.User;
import com.simple.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StartupSpring {

    @Autowired
    private UserService userService;

    @EventListener(ContextRefreshedEvent.class)
    void contextRefreshedEvent() {
        User user = userService.findUserByLogin("admin");
        if(user == null){
            user = new User("admin", "admin");
            user.setRole(Role.ADMIN);
            userService.addUser(user);
        }
    }
}