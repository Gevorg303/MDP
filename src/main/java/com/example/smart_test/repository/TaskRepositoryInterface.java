package com.example.smart_test.repository;


import com.example.smart_test.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepositoryInterface extends JpaRepository<Task, Long> {

}