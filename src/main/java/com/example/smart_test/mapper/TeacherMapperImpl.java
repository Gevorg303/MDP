package com.example.smart_test.mapper;

import com.example.smart_test.domain.Teacher;
import com.example.smart_test.dto.TeacherDto;
import com.example.smart_test.mapper.api.TeacherMapperInterface;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapperImpl implements TeacherMapperInterface {
    @Override
    public TeacherDto toDto(Teacher entity){
        TeacherDto dto = new TeacherDto();
        dto.setId(entity.getId());
        dto.setEmail(entity.getEmail());
        dto.setName(entity.getName());
        dto.setLogin(entity.getLogin());
        dto.setPatronymic(entity.getPatronymic());
        dto.setPassword(entity.getPassword());
        dto.setSurname(entity.getSurname());
        dto.setSuperUser(entity.isSuperUser());
        return dto;
    }
    @Override
    public Teacher toEntity(TeacherDto dto){
        Teacher entity = new Teacher();
        entity.setId(dto.getId());
        entity.setEmail(dto.getEmail());
        entity.setName(dto.getName());
        entity.setLogin(dto.getLogin());
        entity.setPatronymic(dto.getPatronymic());
        entity.setPassword(dto.getPassword());
        entity.setSurname(dto.getSurname());
        entity.setSuperUser(dto.isSuperUser());
        return entity;
    }
}
