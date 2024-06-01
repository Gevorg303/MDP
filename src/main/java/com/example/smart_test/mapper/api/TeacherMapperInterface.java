package com.example.smart_test.mapper.api;

import com.example.smart_test.domain.Teacher;
import com.example.smart_test.dto.TeacherDto;

public interface TeacherMapperInterface {
    public TeacherDto toDto(Teacher entity);
    public Teacher toEntity(TeacherDto dto);

}
