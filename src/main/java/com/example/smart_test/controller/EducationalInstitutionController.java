package com.example.smart_test.controller;

import org.springframework.ui.Model;
import com.example.smart_test.dto.EducationalInstitutionDto;
import com.example.smart_test.service.api.EducationalInstitutionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/educational-institutions")
public class EducationalInstitutionController {

    @Autowired
    private EducationalInstitutionServiceInterface educationalInstitutionService;

    @PostMapping("/add")
    public EducationalInstitutionDto addEducationalInstitution(@RequestBody EducationalInstitutionDto educationalInstitutionDto) {
        return educationalInstitutionService.addEducationalInstitutionDto(educationalInstitutionDto);
    }

    @DeleteMapping("/delete")
    public void deleteEducationalInstitution(@RequestBody EducationalInstitutionDto educationalInstitutionDto) {
        educationalInstitutionService.deleteEducationalInstitutionDto(educationalInstitutionDto);
    }

    @GetMapping("/all")
    public List<EducationalInstitutionDto> getAllEducationalInstitutions() {
        return educationalInstitutionService.getAllEducationalInstitutions();
    }
}