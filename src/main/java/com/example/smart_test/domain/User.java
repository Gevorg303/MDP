package com.example.smart_test.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "пользователь")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "идентификатор_пользователя")
    private Long id;
    @Column(name = "email_пользователя")
    private String email;
    @Column(name = "имя_пользователя")
    private String name;
    @Column(name = "логин_пользователя")
    private String login;
    @Column(name = "отчество_пользователя")
    private String patronymic;
    @Column(name = "пароль_пользователя")
    private String password;
    @Column(name = "фамилия_пользователя")
    private String surname;
   // @OneToMany(mappedBy = "user"/*, cascade = CascadeType.ALL, fetch = FetchType.LAZY*/)
   // @JoinColumn(name = "роль_пользователя")
   //private Set<Role> roles;
   @ManyToOne
   @JoinColumn(name = "роль_пользователя")
   private Role roles;

}
