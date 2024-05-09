package com.example.smart_test.dto;

import com.example.smart_test.domain.EducationalInstitution;
import com.example.smart_test.domain.StudentClass;
import lombok.Data;

@Data
public class StudentDto {
    private Long id;
    private String email;
    private StudentClass studentClass;
    private String name;
    private String login;
    private String patronymic;
    private String password;
    private String surname;
    private EducationalInstitution educationalInstitution;
}
