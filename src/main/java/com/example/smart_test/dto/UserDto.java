package com.example.smart_test.dto;

import com.example.smart_test.domain.Role;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
@Data
public class UserDto {
    private Long id;
    private String email;
    private String name;
    private String login;
    private String patronymic;
    private String password;
    private String surname;
    private Role roles;
   // private Set<Role> roles;
}
