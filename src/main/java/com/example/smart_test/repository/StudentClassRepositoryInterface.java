package com.example.smart_test.repository;

import com.example.smart_test.domain.StudentClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentClassRepositoryInterface extends JpaRepository<StudentClass, Long> {

}
