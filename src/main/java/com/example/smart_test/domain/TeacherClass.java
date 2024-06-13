package com.example.smart_test.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "учитель_класс")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "идентификатор_учитель_класс")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "идентификатор_класс")
    private StudentClass studentClass;

    @ManyToOne
    @JoinColumn(name = "идентификатор_пользователя")
    private User user;
}
