package com.example.smart_test.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class TeacherDto {
    private Long id;
    private String email;
    private String name;
    private String login;
    private String patronymic;
    private String password;
    private String surname;
    private boolean superUser;
}
