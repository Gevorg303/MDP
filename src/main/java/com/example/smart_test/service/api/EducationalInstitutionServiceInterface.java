package com.example.smart_test.service.api;

import com.example.smart_test.dto.EducationalInstitutionDto;

public interface EducationalInstitutionServiceInterface {
    EducationalInstitutionDto addEducationalInstitutionDto(EducationalInstitutionDto dto);
    void deleteEducationalInstitutionDto(Long id);
}
