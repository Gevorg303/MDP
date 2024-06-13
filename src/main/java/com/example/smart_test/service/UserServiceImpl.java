package com.example.smart_test.service;

import com.example.smart_test.domain.User;
import com.example.smart_test.dto.UserDto;
import com.example.smart_test.mapper.api.UserMapperInterface;
import com.example.smart_test.repository.UserRepositoryInterface;
import com.example.smart_test.service.api.UserServiceInterface;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserServiceInterface {
    @Autowired
    private UserRepositoryInterface userRepository;
    @Autowired
    private UserMapperInterface userMapper;
    @Autowired
    private UserServiceInterface userService;

    @Override
    @Transactional
    public UserDto addUser(UserDto userDto) {
        User userEntity = userMapper.toEntity(userDto);
        userRepository.save(userEntity);
        return userDto;
    }

    @Override
    @Transactional
    public void deleteUser(UserDto userDto) {
        userRepository.deleteById(userDto.getId());
    }

    @Override
    @Transactional
    public List<UserDto> getAllUsers() {
        List<User> userEntities = userRepository.findAll();
        return userEntities.stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserDto getUserByLogin(UserDto userDto) {
        User userEntity = userRepository.findById(userDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Пользователь с таким логином не найден"));
        return userMapper.toDTO(userEntity);
    }

    @Override
    public UserDetails loadUserByUsername(UserDto userDto) throws UsernameNotFoundException {
        UserDto dto = getUserByLogin(userDto);
        if (Objects.isNull(null)) {
            throw new UsernameNotFoundException(String.format("User %s is not found", userDto.getLogin()));
        }
        return new org.springframework.security.core.userdetails.User(dto.getLogin(), dto.getPassword(), true, true, true, true, new HashSet<>());
    }
}
