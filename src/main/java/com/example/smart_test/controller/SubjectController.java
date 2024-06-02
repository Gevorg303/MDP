package com.example.smart_test.controller;

import com.example.smart_test.dto.SubjectDto;
import com.example.smart_test.repository.SubjectRepositoryInterface;
import com.example.smart_test.service.api.SubjectServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    private SubjectServiceInterface subjectService;
    @PostMapping("/add")//не работает
    public SubjectDto addSubjectDto(@RequestBody SubjectDto subjectDto){
        return subjectService.addSubjectDto(subjectDto);
    }
    @DeleteMapping("/delete")
    public void deleteSubjectDto(@RequestBody SubjectDto subjectDto){
        subjectService.deleteSubjectDto(subjectDto);
    }
    @GetMapping("/all")
    public List<SubjectDto> getSubjectDto(){
        return subjectService.getAllSubject();
    }
}
