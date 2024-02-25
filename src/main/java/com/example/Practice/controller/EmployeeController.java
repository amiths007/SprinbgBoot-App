package com.example.Practice.controller;

import com.example.Practice.model.Employee;
import com.example.Practice.service.EmployeeServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping("/get/all/v1")
    public ResponseEntity<List<Employee>> getAllEmployeeList() throws Exception {
        return employeeService.getAllEmployeeData();
    }

    @PostMapping("/post/employees/v1")
    public ResponseEntity<List<Employee>> create(@RequestBody @Valid List<Employee> employee) throws Exception {
        return employeeService.createEmployees(employee);
    }

    @GetMapping("/get/employee/v1/{id}")
    public ResponseEntity<Optional<Employee>> getEmployeeId(@PathVariable @Valid int id) throws Exception {
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable @Valid int id) throws Exception {
        return employeeService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody @Valid Employee employee) throws Exception {
        return employeeService.updateEmployee(id, employee);

    }
}
