package com.example.smart_test.dto;

import com.example.smart_test.domain.StudentClass;
import com.example.smart_test.domain.Teacher;
import jakarta.persistence.Column;
import lombok.Data;

public class TeacherClassDto {
    private Long id;
    private StudentClass studentClass;
    private Teacher teacher;
}
