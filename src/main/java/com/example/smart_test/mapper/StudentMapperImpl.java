package com.example.smart_test.mapper;

import com.example.smart_test.domain.Student;
import com.example.smart_test.dto.StudentDto;
import com.example.smart_test.mapper.api.StudentMapperInterface;
import org.springframework.stereotype.Component;

@Component
public class StudentMapperImpl implements StudentMapperInterface {
    @Override
    public StudentDto toDTO(Student entity) {
        StudentDto dto = new StudentDto();
        dto.setId(entity.getId());
        dto.setEmail(entity.getEmail());
        dto.setStudentClass(entity.getStudentClass());
        dto.setName(entity.getName());
        dto.setLogin(entity.getLogin());
        dto.setPatronymic(entity.getPatronymic());
        dto.setPassword(entity.getPassword());
        dto.setSurname(entity.getSurname());
        dto.setEducationalInstitution(entity.getEducationalInstitution());
        return dto;
    }

    @Override
    public Student toEntity(StudentDto dto) {
        Student entity = new Student();
        entity.setId(dto.getId());
        entity.setEmail(dto.getEmail());
        entity.setStudentClass(dto.getStudentClass());
        entity.setName(dto.getName());
        entity.setLogin(dto.getLogin());
        entity.setPatronymic(dto.getPatronymic());
        entity.setPassword(dto.getPassword());
        entity.setSurname(dto.getSurname());
        entity.setEducationalInstitution(dto.getEducationalInstitution());
        return entity;
    }
}
