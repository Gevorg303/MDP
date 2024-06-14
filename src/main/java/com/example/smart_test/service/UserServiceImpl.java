package com.example.smart_test.service;

import com.example.smart_test.domain.User;
import com.example.smart_test.dto.UserDto;
import com.example.smart_test.mapper.api.UserMapperInterface;
import com.example.smart_test.repository.UserRepositoryInterface;
import com.example.smart_test.service.api.UserServiceInterface;
import io.swagger.v3.oas.models.examples.Example;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepositoryInterface userRepository;
    @Autowired
    private UserMapperInterface userMapper;
  //  @Autowired
  //  private UserServiceInterface userService;

   // @Override
    @Transactional
    public UserDto addUser(UserDto userDto) {
        User userEntity = userMapper.toEntity(userDto);
        userRepository.save(userEntity);
        return userDto;
    }

   // @Override
    @Transactional
    public void deleteUser(UserDto userDto) {
        userRepository.deleteById(userDto.getId());
    }

   // @Override
    @Transactional
    public List<UserDto> getAllUsers() {
        List<User> userEntities = userRepository.findAll();
        return userEntities.stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

  //  @Override
    @Transactional
    public UserDto getUserByLogin(UserDto userDto) {
        User userEntity = userRepository.findById(userDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Пользователь с таким логином не найден"));
        return userMapper.toDTO(userEntity);
    }

    public User getUserByLogin(String login) {
        User userEntity = userRepository.findByLogin(login)
                .orElseThrow(() -> new IllegalArgumentException("Пользователь с таким логином не найден"));
        return userEntity;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        User u = getUserByLogin(login);
        if (Objects.isNull(u)) {
            throw new UsernameNotFoundException(String.format("User %s is not found", login));
        }
        return new org.springframework.security.core.userdetails.User(u.getLogin(), u.getPassword(), true, true, true, true, new HashSet<>());
    }
}
