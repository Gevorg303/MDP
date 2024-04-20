package com.example.smart_test.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Учитель_класс")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "идентификатор_учитель_класс")
    private Long id;
    @ManyToMany
    @JoinColumn(name = "идентификатор_класс")
    private StudentClass studentClass;
    @ManyToMany
    @JoinColumn(name = "идентификатор_учителя")
    private Teacher teacher;
}
