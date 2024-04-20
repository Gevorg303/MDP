package com.example.smart_test.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Класс")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "идентификатор_класс")
    private Long id;
    @Column(name = "буквенное_обозначение")
    private String letterDesignation;
    @ManyToOne
    @Column(name = "идентификатор_образовательное_уч")
    private EducationalInstitution educationalInstitution;
    @OneToMany
    @Column(name = "идентификатор_ученик")
    private Student student;
//    @ManyToMany(mappedBy = "TeacherClass")
//    @Column(name = "идентификатор_учитель_класс")
//    private TeacherClass teacherClass;
    @Column(name = "номер_учреждения")
    private String numberOfInstitution;
}
