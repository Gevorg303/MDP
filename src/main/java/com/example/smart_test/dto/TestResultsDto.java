package com.example.smart_test.dto;

import com.example.smart_test.domain.Indicator;
import com.example.smart_test.domain.Student;
import com.example.smart_test.domain.Task;
import com.example.smart_test.domain.Test;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class TestResultsDto {
    private Long id;
    private Task task;
    private Indicator indicator;
    private Test test;
    private Student student;
    private boolean resultOfTheIndicator;
}
