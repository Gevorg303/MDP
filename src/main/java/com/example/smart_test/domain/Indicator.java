package com.example.smart_test.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Индикатор")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Indicator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "идентификатор_индикатора")
    private Long id;
//    @ManyToMany
//    @Column(name = "")
//    private Task task;
    @OneToMany
    @Column(name = "идентификатор_результаты_теста")
    private List<TestResults> testResultsList;
    @ManyToOne
    @Column(name = "идентификатор_тема")
    private Theme theme;
    @Column(name = "наименование_индикатора")
    private String nameOfTheIndicator;
}
