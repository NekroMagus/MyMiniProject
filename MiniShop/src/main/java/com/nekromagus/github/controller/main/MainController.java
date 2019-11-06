package com.nekromagus.github.controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for index page
 *
 * @author Igor Fliginskikh
 * @version 1.0
 */

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping
    public String mainPage() {
        return "index";
    }
}
