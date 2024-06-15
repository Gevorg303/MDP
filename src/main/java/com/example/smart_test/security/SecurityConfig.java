package com.example.smart_test.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Настройка авторизации HTTP-запросов
                .authorizeHttpRequests((requests) -> requests
                        // Разрешает доступ ко всем запросам, соответствующим шаблону /public/**
                        .requestMatchers("/auth/**").permitAll()
                        // Все остальные запросы требуют аутентификации
                        .anyRequest().authenticated()
                )
                // Настройка формы для входа
                .formLogin((form) -> form
                        // Указывает URL страницы входа
                        .loginPage("/login")
                        // Разрешает доступ к странице входа для всех
                        .permitAll()
                )
                // Настройка параметров выхода из приложения
                .logout((logout) -> logout
                        // Разрешает доступ к функционалу выхода для всех
                        .permitAll()
                );
        // Создает и возвращает объект SecurityFilterChain
        return http.build();
    }


    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }
}