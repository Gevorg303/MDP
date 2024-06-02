package com.example.smart_test.repository;

import com.example.smart_test.domain.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThemeRepositoryInterface extends JpaRepository<Theme, Long> {

}
