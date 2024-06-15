package com.example.smart_test.service;

import com.example.smart_test.domain.User;
import com.example.smart_test.dto.UserDto;
import com.example.smart_test.mapper.api.UserMapperInterface;
import com.example.smart_test.repository.UserRepositoryInterface;
import com.example.smart_test.service.api.AuthServiceInterface;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthServiceImpl implements AuthServiceInterface {

    @Autowired
    private UserRepositoryInterface userRepository;
    @Autowired
    private UserMapperInterface userMapper;

    @Override
    @Transactional
    public UserDto checkUser(UserDto dto) {
        User userEntity = userRepository.findByLogin(dto.getLogin())
                .orElseThrow(() -> new IllegalArgumentException("Пользователь с таким логином не найден"));
        if (userEntity.getLogin().equals(dto.getLogin()) && userEntity.getPassword().equals(dto.getPassword())) {
            return userMapper.toDTO(userEntity);
        } else {
            return null;
        }
    }

}
