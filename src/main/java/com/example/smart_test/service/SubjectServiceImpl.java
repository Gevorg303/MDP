package com.example.smart_test.service;

import com.example.smart_test.domain.Subject;
import com.example.smart_test.dto.SubjectDto;
import com.example.smart_test.repository.SubjectRepositoryInterface;
import com.example.smart_test.service.api.SubjectServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Slf4j
public class SubjectServiceImpl implements SubjectServiceInterface {
    @Autowired
    private SubjectRepositoryInterface subjectRepository;
    @Override
    public SubjectDto addSubjectDto(SubjectDto dto) {
        return null;
    }

    @Override
    public void deleteSubjectDto(SubjectDto dto) {

    }

    @Override
    public List<SubjectDto> getAllSubject() {
        return null;
    }

    private boolean findStudentById(Long id) {
        Optional<Subject> subject = subjectRepository.findById(id);
        return subject.isPresent();
    }
}
