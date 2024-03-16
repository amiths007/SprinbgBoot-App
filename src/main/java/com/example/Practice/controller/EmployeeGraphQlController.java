package com.example.Practice.controller;

import com.example.Practice.model.Employee;
import com.example.Practice.service.EmployeeGraphqlServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeGraphQlController {

    @Autowired
    private EmployeeGraphqlServiceImpl employeeGraphqlService;

    @QueryMapping
    public List<Employee> getAllEmployeeList() throws Exception {
        return employeeGraphqlService.getAllEmployeeData();
    }


    @MutationMapping
    public List<Employee> create(@Argument @Valid List<Employee> employee) throws Exception {
        return employeeGraphqlService.createEmployees(employee);
    }

    @QueryMapping
    public List<Employee> getFilteredEmployeeList(@Argument String email) throws Exception {
        return employeeGraphqlService.getFilteredEmployeesEmail();
    }

    @QueryMapping
    public Optional<Employee> getEmployeeId(@Argument @Valid int id) throws Exception {
        return employeeGraphqlService.getEmployeeById(id);
    }

    @MutationMapping
    public void deleteEmployee(@Argument @Valid int id) throws Exception {
        employeeGraphqlService.deleteById(id);
    }

    @MutationMapping
    public Employee updateEmployee(@Argument int id, @Argument @Valid Employee employee) throws Exception {
        return employeeGraphqlService.updateEmployee(id, employee);

    }
}
