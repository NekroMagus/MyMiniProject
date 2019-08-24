package com.simple.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/users")
public class UserController {

    @GetMapping
    public String getUsersPage(){
        return "users";
    }
}
