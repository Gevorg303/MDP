package com.example.smart_test.service;

import com.example.smart_test.domain.Teacher;
import com.example.smart_test.dto.TeacherDto;
import com.example.smart_test.mapper.api.TeacherMapperInterface;
import com.example.smart_test.repository.StudentClassRepositoryInterface;
import com.example.smart_test.repository.StudentRepositoryInterface;
import com.example.smart_test.repository.TeacherRepositoryInterface;
import com.example.smart_test.service.api.TeacherServiceInterface;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

@Service
public class UserService implements UserDetailsService {

    private TeacherRepositoryInterface teacherRepository;
    private TeacherServiceInterface teacherService;
    private TeacherMapperInterface teacherMapper;

    public UserService(TeacherRepositoryInterface repository) {
        this.teacherRepository = repository;
    }

    public List<Teacher> getAll() {
       return this.teacherRepository.findAll();
    }

    public Teacher getByLogin(String login) {
        TeacherDto dto = new TeacherDto();
        dto.setLogin(login);
        return teacherMapper.toEntity(this.teacherService.getTeacherByLogin(dto));
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Teacher u = getByLogin(login);
        if (Objects.isNull(u)) {
            throw new UsernameNotFoundException(String.format("User %s is not found", login));
        }
        return new org.springframework.security.core.userdetails.User(u.getLogin(), u.getPassword(), true, true, true, true, new HashSet<>());
    }
}
