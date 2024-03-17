package com.example.Practice.service;

import com.example.Practice.model.Employee;
import com.example.Practice.model.EmployeeInput;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface EmployeeGraphqlService {
    public List<Employee> getAllEmployeeData();
    public List<EmployeeInput> createEmployees(List<EmployeeInput> employees);
    
    public List<Employee> getFilteredEmployeesEmail();
    public Optional<Employee> getEmployeeById(int id);
    public void deleteById(int id);
    public Employee updateEmployee(int id, Employee employee);
}
