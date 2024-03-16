package com.example.Practice.service;

import com.example.Practice.model.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface EmployeeGraphqlService {
    public List<Employee> getAllEmployeeData();
    public List<Employee> createEmployees(List<Employee> employees);
    
    public List<Employee> getFilteredEmployeesEmail();
    public Optional<Employee> getEmployeeById(int id);
    public void deleteById(int id);
    public Employee updateEmployee(int id, Employee employee);
}
