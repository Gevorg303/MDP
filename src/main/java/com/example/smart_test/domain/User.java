package com.example.smart_test.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "пользователь")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {
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
    @ManyToOne
    @JoinColumn(name = "роль_пользователя")
    private Role roles;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
