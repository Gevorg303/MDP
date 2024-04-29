package com.example.smart_test.repository;

import com.example.smart_test.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepositoryInterface extends JpaRepository<Student, Long> {

}
