package com.example.smart_test.service;

import com.example.smart_test.domain.EducationalInstitution;
import com.example.smart_test.domain.Student;
import com.example.smart_test.dto.StudentDto;
import com.example.smart_test.mapper.api.StudentMapperInterface;
import com.example.smart_test.repository.StudentRepositoryInterface;
import com.example.smart_test.service.api.StudentServiceInterface;
import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class StudentServiceImpl implements StudentServiceInterface {
    @Autowired
    private StudentRepositoryInterface studentRepository;
    @Autowired
    private StudentMapperInterface studentMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public StudentDto addStudentDto(StudentDto dto) {
        try {
            dto.setLogin(generateLogin(dto));
            dto.setPassword(generatePassword());
            Student student = studentMapper.toEntity(dto);
            student = studentRepository.save(student);
            return studentMapper.toDTO(student);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при добавлении ученика: " + e.getMessage(), e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void deleteStudentDto(StudentDto dto) {
        if (findStudentById(dto.getId())) {
            Student student = studentMapper.toEntity(dto);
            studentRepository.delete(student);
        } else {
            log.error("Ученик с идентификатором " + dto.getId() + " не существует");
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<StudentDto> getAllStudent() {
        try {
            List<Student> institutions = studentRepository.findAll();
            return institutions.stream()
                    .map(studentMapper::toDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при получении всех учеников: " + e.getMessage(), e);
        }
    }

    private String generateLogin(StudentDto dto) {
        String surnameInitials = dto.getSurname().substring(0, Math.min(dto.getSurname().length(), 2));
        String nameInitials = dto.getName().substring(0, Math.min(dto.getName().length(), 2));
        String patronymicInitials = "";
        if (dto.getPatronymic() != null && !dto.getPatronymic().isEmpty()) {
            patronymicInitials = dto.getPatronymic().substring(0, Math.min(dto.getPatronymic().length(), 2));
        }
        Faker faker = new Faker();
        String randomNumber = faker.number().digits(5);
        return surnameInitials + nameInitials + patronymicInitials + randomNumber;
    }

    private String generatePassword() {
        Faker faker = new Faker();
        return faker.internet().password(8, 16, true, true, true);
    }

    private boolean findStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.isPresent();
    }
}
