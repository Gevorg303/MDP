package com.example.smart_test.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Ученик")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "идентификатор_ученика")
    private Long id;
    @Column(name = "email_ученика")
    private String email;
    @ManyToOne
    @Column(name = "идентификатор_класс")
    private StudentClass studentClass;
    @OneToMany
    @Column(name = "идентификатор_результаты_теста")
    private List<TestResults> testResultsList;
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
}
