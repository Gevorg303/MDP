package com.example.smart_test.controller;

import com.example.smart_test.CustomAuthenticationProvider;
import com.example.smart_test.dto.UserDto;
import com.example.smart_test.service.AuthServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final CustomAuthenticationProvider authenticationProvider;

    public AuthController(CustomAuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }

    @PostMapping("/login")
    public String login(@RequestParam("login") String username,
                        @RequestParam("password") String password,
                        HttpSession session) {
        Authentication authentication = authenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());
        return "redirect:/test-smart/main";
    }
    @GetMapping("/main")
    public String openMain() {
        return "main";
    }
}