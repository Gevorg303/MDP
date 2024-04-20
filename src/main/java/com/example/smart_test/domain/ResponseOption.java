package com.example.smart_test.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Вариант_ответа")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "идентификатор_вариант_ответа")
    private Long id;
    @Column(name = "вопрос")
    private String question;
    @ManyToOne
    @Column(name = "идентификатор_задание")
    private Task task;
    @Column(name = "ответ")
    private String response;
    @Column(name = "оценка_за_ответ")
    private String evaluationResponse;
}
