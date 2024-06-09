package com.example.smart_test.service;


import com.example.smart_test.domain.Teacher;
import com.example.smart_test.dto.TeacherDto;
import com.example.smart_test.mapper.api.TeacherMapperInterface;
import com.example.smart_test.repository.TeacherRepositoryInterface;
import com.example.smart_test.service.api.TeacherServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
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
        if (findTeacherById(dto.getId())) {
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
    @Override
    public TeacherDto getTeacherByLogin(TeacherDto dto) {
        TeacherDto result = null;
        try {
            List<Teacher> teachers = teacherRepositoryInterface.findAll();
            List<TeacherDto> dtos = teachers.stream().map(teacherMapperInterface::toDto).collect(Collectors.toList());

            for(int i = 0; i < dtos.size(); i++) {
                if(Objects.equals(dtos.get(i).getLogin(), dto.getLogin()))
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
    public Boolean checkPasswordByLogin(TeacherDto dto) {
        try {
            List<Teacher> students = teacherRepositoryInterface.findAll();
            List<TeacherDto> dtos = students.stream().map(teacherMapperInterface::toDto).collect(Collectors.toList());

            for(int i = 0; i < dtos.size(); i++) {
                String dtoLogin = dtos.get(i).getLogin();
                if(dtoLogin == dto.getLogin()) {
                    String dtoPassword = dtos.get(i).getPassword();
                    if(dtoPassword == dto.getPassword()) {
                        return true;
                    }

                }

            }
        } catch (Exception e) {
            throw new RuntimeException( e.getMessage(), e);
        }
        return false;
    }

    private boolean findTeacherById(Long id) {
        Optional<Teacher> teacher = teacherRepositoryInterface.findById(id);
        return teacher.isPresent();
    }
}
