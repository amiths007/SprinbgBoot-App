package com.example.Practice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
@Data
@Table(name = "EmployeeDetails")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

//    @JsonProperty(value = "financeDetails")
//    @Column(name = "financeDetails")
//    private FinanceDetails financeDetails;

}
