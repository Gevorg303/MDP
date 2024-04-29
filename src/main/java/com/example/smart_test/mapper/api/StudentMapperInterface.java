package com.example.smart_test.mapper.api;

import com.example.smart_test.domain.EducationalInstitution;
import com.example.smart_test.domain.Student;
import com.example.smart_test.dto.EducationalInstitutionDto;
import com.example.smart_test.dto.StudentDto;

public interface StudentMapperInterface {
    StudentDto toDTO(Student entity);
    Student toEntity(StudentDto dto);
}
