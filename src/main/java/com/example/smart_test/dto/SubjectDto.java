package com.example.smart_test.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class SubjectDto {
    private Long id;
    private String subjectName;
    private String description;
}
