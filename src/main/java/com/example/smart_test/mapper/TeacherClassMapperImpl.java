package com.example.smart_test.mapper;

import com.example.smart_test.domain.TeacherClass;
import com.example.smart_test.dto.TeacherClassDto;
import com.example.smart_test.mapper.api.TeacherClassMapperInterface;
import org.springframework.stereotype.Component;

@Component
public class TeacherClassMapperImpl implements TeacherClassMapperInterface {
    @Override
    public TeacherClassDto toDto(TeacherClass entity){
        TeacherClassDto dto = new TeacherClassDto();
        dto.setId(entity.getId());
        dto.setTeacher(entity.getTeacher());
        dto.setStudentClass(entity.getStudentClass());
        return dto;
    }
    @Override
    public TeacherClass toEntity(TeacherClassDto dto){
        TeacherClass entity = new TeacherClass();
        entity.setId(dto.getId());
        entity.setTeacher(dto.getTeacher());
        entity.setStudentClass(dto.getStudentClass());
        return entity;
    }
}
