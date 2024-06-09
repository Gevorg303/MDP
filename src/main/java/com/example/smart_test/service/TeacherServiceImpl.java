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

    private boolean findTeacherById(Long id) {
        Optional<Teacher> teacher = teacherRepositoryInterface.findById(id);
        return teacher.isPresent();
    }
}
