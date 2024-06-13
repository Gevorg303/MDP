package com.example.smart_test.service.api;

import com.example.smart_test.dto.UserDto;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserServiceInterface {
    @Transactional
    UserDto addUser(UserDto userDto);

    @Transactional
    void deleteUser(UserDto userDto);

    @Transactional
    List<UserDto> getAllUsers();

    @Transactional
    UserDto getUserByLogin(UserDto userDto);

    UserDetails loadUserByUsername(UserDto userDto) throws UsernameNotFoundException;
}
