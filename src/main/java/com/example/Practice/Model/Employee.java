package com.example.Practice.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "EmployeeDetails")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int age;
    private String companyName;

}
