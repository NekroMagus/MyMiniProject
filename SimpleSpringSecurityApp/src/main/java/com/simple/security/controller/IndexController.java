package com.simple.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String indexPage() {
        return "index";
    }

    @GetMapping("/index")
    public String indexPages() {
        return "index";
    }
}
