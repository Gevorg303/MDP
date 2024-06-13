package com.example.smart_test.repository;

import com.example.smart_test.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryInterface extends JpaRepository <User, Long> {

}
