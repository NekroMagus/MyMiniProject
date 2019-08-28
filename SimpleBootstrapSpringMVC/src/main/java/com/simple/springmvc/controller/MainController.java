package com.simple.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping
    public String mainPage() {
        return "index";
    }

    @GetMapping("/index")
    public String mainPage2(){return "index";}
}
