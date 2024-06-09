package com.example.smart_test.service.api;

import com.example.smart_test.dto.TeacherDto;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TeacherServiceInterface {
    public TeacherDto addTeacherDto(TeacherDto dto);

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void deleteTeacherDto(TeacherDto dto);

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<TeacherDto> getAllTeachers();

}
