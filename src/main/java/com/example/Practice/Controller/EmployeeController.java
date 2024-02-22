package com.example.Practice.Controller;

import com.example.Practice.Model.Employee;
import com.example.Practice.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/get/all/v1")
    public List<Employee> getAllEmployeeList(){
        return employeeService.getAllEmployeeData();
    }

    @PostMapping("/post/employees/v1")
    public List<Employee> addEmployee(@RequestBody List<Employee> employee){
        return employeeService.addEmployees(employee);
    }

    @GetMapping("/get/employee/v1/{id}")
    public Optional<Employee> updateEmployee(@PathVariable int id){
        return employeeService.getEmployeeById(id);
    }
}
