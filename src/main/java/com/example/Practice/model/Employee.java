package com.example.Practice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@jakarta.persistence.Entity
@Data
@jakarta.persistence.Table(name = "EmployeeDetails")
public class Employee {

    @jakarta.persistence.Id
    @jakarta.persistence.GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Employee ID", unique = true, updatable = true, nullable = true, length = 9999)
    private int id;

    @JsonProperty(value = "firstName")
    @NotBlank(message = "FIELD CANNOT BE EMPTY")
    private String firstName;

    @JsonProperty(value = "lastName")
    @NotBlank(message = "FIELD CANNOT BE EMPTY")
    private String lastName;

    @JsonProperty(value = "age")
    private int age;

    @JsonProperty(value = "companyName")
    @NotBlank(message = "FIELD CANNOT BE EMPTY")
    private String companyName;

    @JsonProperty(value = "financeDetails")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "referenceId")
    private FinanceDetails financeDetails;

}
