package com.example.Practice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "FinanceDetails")
public class FinanceDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int referenceId;

    @JsonProperty(value = "salary")
    private String salary;

    @JsonProperty(value = "role")
    private String role;

    @JsonProperty(value = "grade")
    private String grade;
}
