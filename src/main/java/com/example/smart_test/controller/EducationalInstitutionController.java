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
    public ResponseEntity<EducationalInstitutionDto> addEducationalInstitution(@RequestBody EducationalInstitutionDto dto) {
        EducationalInstitutionDto addedInstitution = educationalInstitutionService.addEducationalInstitutionDto(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedInstitution);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteEducationalInstitution(@RequestBody EducationalInstitutionDto dto) {
        educationalInstitutionService.deleteEducationalInstitutionDto(dto);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/all")
    public ResponseEntity<List<EducationalInstitutionDto>> getAllEducationalInstitutions() {
        List<EducationalInstitutionDto> institutions = educationalInstitutionService.getAllEducationalInstitutions();
        return ResponseEntity.ok().body(institutions);
    }
}