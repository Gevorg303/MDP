package com.example.smart_test.dto;

import com.example.smart_test.domain.Theme;
import jakarta.persistence.Column;
import lombok.Data;

public class IndicatorDto {
    private Long id;
    private Theme theme;
    private String nameOfTheIndicator;
}
