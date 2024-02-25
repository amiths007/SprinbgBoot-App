package com.example.Practice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;

@Entity
@Data
@jakarta.persistence.Table(name = "EmployeeDetails")
@Validated
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @JsonProperty(value = "firstName")
    @NotBlank(message = "Please provide first name")
    private String firstName;

    @JsonProperty(value = "lastName")
    @NotBlank(message = "Please provide last name")
    private String lastName;

    @JsonProperty(value = "age")
    @NotNull(message = "Invalid Age, please enter value greater than 0")
    @Range(min = 0, max = 999)
    private int age;

    @JsonProperty(value = "companyName")
    @NotBlank(message = "Please provide company name")
    private String companyName;

    @JsonProperty(value = "financeDetails")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employeeId")
    @Valid
    private FinanceDetails financeDetails;

}
