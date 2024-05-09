package com.example.smart_test.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "ученик")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "идентификатор_ученик")
    private Long id;
    @Column(name = "email_ученика")
    private String email;
    @ManyToOne
    @JoinColumn(name = "идентификатор_класс")
    private StudentClass studentClass;
    @Column(name = "имя_ученика")
    private String name;
    @Column(name = "логин_ученика")
    private String login;
    @Column(name = "отчество_ученика")
    private String patronymic;
    @Column(name = "пароль_ученика")
    private String password;
    @Column(name = "фамилия_ученика")
    private String surname;
    @ManyToOne
    @JoinColumn(name = "идентификатор_образовательное_уч")
    private EducationalInstitution educationalInstitution;
}
