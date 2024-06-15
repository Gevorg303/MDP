package com.example.smart_test.controller;

import com.example.smart_test.dto.UserDto;
import com.example.smart_test.service.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthServiceImpl authService;
    @PostMapping("/login")
    public UserDto login(@RequestBody UserDto dto) {
        return authService.checkUser(dto);
    }

    @PostMapping("/register")
    public UserDto register(@RequestBody UserDto dto) {
        return null;
    }
}