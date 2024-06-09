package com.example.smart_test.service;

import com.example.smart_test.domain.Student;
import com.example.smart_test.domain.Subject;
import com.example.smart_test.dto.SubjectDto;
import com.example.smart_test.mapper.api.SubjectMapperInterface;
import com.example.smart_test.repository.SubjectRepositoryInterface;
import com.example.smart_test.service.api.SubjectServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@Slf4j
public class SubjectServiceImpl implements SubjectServiceInterface {
    @Autowired
    private SubjectRepositoryInterface subjectRepository;
    @Autowired
    private SubjectMapperInterface subjectMapper;
    @Override
    public SubjectDto addSubjectDto(SubjectDto dto) {
        try {
            Subject subject = subjectMapper.toEntity(dto);
            subject = subjectRepository.save(subject);
            return subjectMapper.toDTO(subject);
        } catch (Exception e) {
            throw new RuntimeException("Не удалось добавить предмет" + e.getMessage(), e);
        }
    }



    @Override
    public List<SubjectDto> getAllSubject() {
        try {
            List<Subject> subjects = subjectRepository.findAll();
            List<SubjectDto> subjectDto = new ArrayList<>();
            for (Subject subject : subjects) {
                subjectDto.add(subjectMapper.toDTO(subject));
            }
            return subjectDto;
        }catch (Exception e) {
            throw new RuntimeException("Не удалось получить список предметов." + e.getMessage(), e);
        }

    }
    @Override
    public SubjectDto getSubjectById(Long id) {
        try {
            Subject subject = subjectRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Предмет не найден"));
            return subjectMapper.toDTO(subject);
        } catch (Exception e) {
            throw new RuntimeException("Не удалось получить предмет: " + e.getMessage(), e);
        }
    }
    @Override
    public void deleteSubjectDto(SubjectDto dto) {
        /*Удаление будем реализовывать потом
         * когда будет сделана авторизация по JWT ключу
         * */
    }
}
