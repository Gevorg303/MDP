package com.example.smart_test.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "Тест")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "идентификатор_тест")
    private Long id;
    @Column(name = "время_прохождения")
    private LocalTime passageTime;
    @Column(name = "дата_и_время_закрытия")
    private LocalDateTime closingDateAndTime;
    @Column(name = "дата_и_время_открытия")
    private LocalDateTime openingDateAndTime;
    @OneToMany
    @Column(name = "идентификатор_задание")
    private List<Task> taskList;
    @OneToMany
    @Column(name = "идентификатор_результаты_теста")
    private List<TestResults> testResultsList;
    @ManyToOne
    @Column(name = "идентификатор_тема")
    private Theme theme;
    @ManyToOne
    @Column(name = "идентификатор_тип_теста")
    private TypeTest typeTest;
    @Column(name = "количество_попыток_прохождения")
    private int numberOfAttemptsToPass;
    @Column(name = "описание")
    private String description;
    @Column(name = "пароль_теста")
    private String testPassword;
}
