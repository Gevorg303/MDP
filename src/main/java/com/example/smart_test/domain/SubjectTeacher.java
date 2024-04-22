package com.example.smart_test.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "учитель_предмет")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectTeacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "идентификатор_учитель_предмет")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "идентификатор_предмет")
    private Subject subject;
    @ManyToOne
    @JoinColumn(name = "идентификатор_учитель")
    private Teacher teacher;
}

