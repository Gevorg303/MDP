package com.example.smart_test.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "учитель")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "идентификатор_учителя")
    private Long id;
    @Column(name = "email_учителя")
    private String email;
    @Column(name = "имя_учителя")
    private String name;
    @Column(name = "логин_учителя")
    private String login;
    @Column(name = "отчество_учителя")
    private String patronymic;
    @Column(name = "пароль_учителя")
    private String password;
    @Column(name = "фамилия_учителя")
    private String surname;
    @Getter
    @Column(name = "супер_пользователь")
    private boolean superUser;
}
