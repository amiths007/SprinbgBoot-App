package com.example.Practice.Service;

import com.example.Practice.Model.Employee;
import com.example.Practice.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    public List<Employee> getAllEmployeeData() {
        return employeeRepository.findAll();
    }

    public List<Employee> addEmployees(List<Employee> employee) {
        return employeeRepository.saveAll(employee);
    }

    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepository.findById(id);
    }
}
