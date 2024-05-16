package com.example.smart_test.dto;

import com.example.smart_test.domain.Task;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class ResposeOptionDto {
    private Long id;
    private String question;
    private Task task;
    private String response;
    private String evaluationResponse;
}
