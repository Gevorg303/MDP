package com.example.smart_test.controller;

import com.example.smart_test.dto.StudentDto;
import com.example.smart_test.service.api.TeacherServiceInterface;
import com.example.smart_test.dto.TeacherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherServiceInterface teacherService;
    @PostMapping("/add")
    public TeacherDto addTeacher(@RequestBody TeacherDto teacherDto){
        return teacherService.addTeacherDto(teacherDto);
    }
    @DeleteMapping("/delete")
    public void  deleteTeacher(@RequestBody TeacherDto teacherDto){
        teacherService.deleteTeacherDto(teacherDto);
    }
    @GetMapping("/all")
    public List<TeacherDto> getAllTeacher(){
        return teacherService.getAllTeachers();
    }

    @GetMapping("/getTeacher")
    public TeacherDto getTeacherByLogin(@RequestBody String login) { return teacherService.getTeacherByLogin(login); }

    @GetMapping("/check")
    public boolean checkTeacher(@RequestBody String login,@RequestBody String password) { return teacherService.checkPasswordByLogin(login,password); }
}
