package com.example.smart_test.repository;

import com.example.smart_test.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepositoryInterface extends JpaRepository<Subject, Long> {

}
