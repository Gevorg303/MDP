package com.example.smart_test.service.api;

import com.example.smart_test.dto.EducationalInstitutionDto;
import com.example.smart_test.dto.StudentDto;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentServiceInterface {
    StudentDto addStudentDto(StudentDto dto);

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    void deleteStudentDto(StudentDto dto);

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    List<StudentDto> getAllStudent();
}
