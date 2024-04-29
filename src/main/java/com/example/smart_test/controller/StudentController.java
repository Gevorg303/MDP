package com.example.smart_test.controller;

import com.example.smart_test.dto.StudentDto;
import com.example.smart_test.service.api.StudentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentServiceInterface studentService;
    @PostMapping("/add")
    public StudentDto addStudent(@RequestBody StudentDto studentDto) {
        return studentService.addStudentDto(studentDto);
    }

    @DeleteMapping("/delete")
    public void deleteStudent(@RequestBody StudentDto studentDto) {
        studentService.deleteStudentDto(studentDto);
    }

    @GetMapping("/all")
    public List<StudentDto> getAllStudents() {
        return studentService.getAllStudent();
    }
}
