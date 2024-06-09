package com.example.smart_test.service;


import com.example.smart_test.domain.Teacher;
import com.example.smart_test.dto.TeacherDto;
import com.example.smart_test.mapper.api.TeacherMapperInterface;
import com.example.smart_test.repository.TeacherRepositoryInterface;
import com.example.smart_test.service.api.TeacherServiceInterface;
import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TeacherServiceImpl implements TeacherServiceInterface {

    @Autowired
    private TeacherRepositoryInterface teacherRepositoryInterface;
    @Autowired
    private TeacherMapperInterface teacherMapperInterface;

    @Override
    public TeacherDto addTeacherDto(TeacherDto dto){
        try{
            Teacher teacher = teacherMapperInterface.toEntity(dto);
            teacher = teacherRepositoryInterface.save(teacher);
            return teacherMapperInterface.toDto(teacher);
        }
        catch (Exception e){
            throw new RuntimeException("Ошибка при добавлении индикатора: " + e.getMessage(), e);
        }
    }
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void deleteTeacherDto(TeacherDto dto) {
        if (teacherRepositoryInterface.findById(dto.getId()).isPresent()) {
            Teacher teacher = teacherMapperInterface.toEntity(dto);
            teacherRepositoryInterface.delete(teacher);
        } else {
            log.error("Индикатор с идентификатором " + dto.getId() + " не существует");
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<TeacherDto> getAllTeachers() {
        try {
            List<Teacher> teachers = teacherRepositoryInterface.findAll();
            return teachers.stream()
                    .map(teacherMapperInterface::toDto)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при получении всех индикаторов: " + e.getMessage(), e);
        }
    }

    private String generateLogin(TeacherDto dto) {
        String surnameInitials = dto.getSurname().substring(0, Math.min(dto.getSurname().length(), 2));
        String nameInitials = dto.getName().substring(0, Math.min(dto.getName().length(), 2));
        String patronymicInitials = "";
        if (dto.getPatronymic() != null && !dto.getPatronymic().isEmpty()) {
            patronymicInitials = dto.getPatronymic().substring(0, Math.min(dto.getPatronymic().length(), 2));
        }
        String id = dto.getId().toString();
        return id + surnameInitials + nameInitials + patronymicInitials ;
    }
    private String generatePassword() {
        Faker faker = new Faker();
        return faker.internet().password(8, 16, true, true, true);
    }
    @Override
    public TeacherDto getTeacherByLogin(String login) {
        TeacherDto result = null;
        try {
            List<Teacher> teachers = teacherRepositoryInterface.findAll();
            List<TeacherDto> dtos = teachers.stream().map(teacherMapperInterface::toDto).collect(Collectors.toList());

            for(int i = 0; i < dtos.size(); i++) {
                if(dtos.get(i).getLogin() == login)
                {
                    result = dtos.get(i);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException( e.getMessage(), e);
        }
        return result;
    }
    @Override
    public Boolean checkPasswordByLogin(String login,String password) {
        try {
            List<Teacher> teachers = teacherRepositoryInterface.findAll();
            List<TeacherDto> dtos = teachers.stream().map(teacherMapperInterface::toDto).collect(Collectors.toList());

            for(int i = 0; i < dtos.size(); i++) {
                String dtoLogin = dtos.get(i).getLogin();
                if(dtoLogin == login) {
                    String dtoPassword = dtos.get(i).getPassword();
                    if(dtoLogin == password) {
                        return true;
                    }

                }

            }
        } catch (Exception e) {
            throw new RuntimeException( e.getMessage(), e);
        }
        return false;
    }
}
