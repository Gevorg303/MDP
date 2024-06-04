package com.example.smart_test.repository;


import com.example.smart_test.domain.TeacherClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherClassRepositoryInterface extends JpaRepository<TeacherClass, Long> {

}