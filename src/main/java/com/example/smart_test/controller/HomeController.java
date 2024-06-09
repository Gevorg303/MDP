package com.example.smart_test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test-smart")
public class HomeController {

    @GetMapping("/login")
    public String openLogin() {
        return "login";
    }
    @GetMapping("/main")
    public String openMain() {
        return "main";
    }
    @GetMapping("/help_login")
    public String openHelpLogin() {
        return "help_login";
    }
}
