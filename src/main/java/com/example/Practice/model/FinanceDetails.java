package com.example.Practice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;

@Entity
@Data
@Table(name = "FinanceDetails")
public class FinanceDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

    @JsonProperty(value = "salary")
    @NotNull(message = "Please provide salary detail")
    @Range(min = 0, max = 999999999)
    private double salary;

    @JsonProperty(value = "role")
    @NotBlank(message = "Please provide assigned role")
    private String role;

    @JsonProperty(value = "grade")
    @NotBlank(message = "Please provide valid grade")
    private String grade;
}
