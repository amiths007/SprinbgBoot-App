package com.example.Practice.service;

import com.example.Practice.model.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {
    public ResponseEntity getAllEmployeeData();
    public ResponseEntity createEmployees(List<Employee> employees);
    public ResponseEntity getFilteredEmployeesEmail();
    public ResponseEntity getEmployeeById(int id);
    public ResponseEntity deleteById(int id);
    public ResponseEntity updateEmployee(int id, Employee employee);

}
