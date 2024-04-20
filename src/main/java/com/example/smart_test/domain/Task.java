package com.example.smart_test.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Задание")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

}
