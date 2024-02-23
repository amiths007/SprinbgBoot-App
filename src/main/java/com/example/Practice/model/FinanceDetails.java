package com.example.Practice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class FinanceDetails {

    @JsonProperty(value = "salary")
    private String salary;

    @JsonProperty(value = "role")
    private String role;

    @JsonProperty(value = "grade")
    private String grade;
}
