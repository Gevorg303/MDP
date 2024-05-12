package com.example.smart_test.dto;

import com.example.smart_test.domain.EducationalInstitution;
import com.example.smart_test.domain.Teacher;
import jakarta.persistence.Column;
import lombok.Data;

public class TeacherEducationalInstitutionDto {
    private Long id;
    private Teacher teacher;
    private EducationalInstitution educationalInstitution;
}
