package com.example.smart_test.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "роль")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "идентификатор_роли")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "название_роли")
    private Roles role;

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "идентификатор_пользователя")
    //private User user;
}
