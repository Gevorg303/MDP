package com.example.smart_test.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "учитель_образовательное_учрежден")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherEducationalInstitution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "идентификатор_учитель_образовате")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "идентификатор_пользователя")
    private User user;

    @ManyToOne
    @JoinColumn(name = "идентификатор_образовательное_уч")
    private EducationalInstitution educationalInstitution;
}
