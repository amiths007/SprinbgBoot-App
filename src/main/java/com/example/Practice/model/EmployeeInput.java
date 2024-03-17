package com.example.Practice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class EmployeeInput extends Employee {


    private String firstName;


    private String lastName;


    private int age;

    private String companyName;


    private String email;


    private String avatar;


    private FinanceDetails financeDetails;
}
