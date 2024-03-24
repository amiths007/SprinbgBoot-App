package com.example.Practice.datafetcher;

import com.example.Practice.model.Employee;
import com.example.Practice.repository.EmployeeRepository;
import com.example.Practice.service.EmployeeGraphqlServiceImpl;
import com.netflix.graphql.dgs.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

/** @noinspection ALL*/
@DgsComponent
public class EmployeeDataFetcher {

    @Autowired
    private EmployeeGraphqlServiceImpl employeeGraphqlService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @DgsData(parentType = "Query", field = "getAllEmployeeList")
    public List<Employee> getAllEmployeeList() {

        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    @DgsData(parentType = "Query", field = "getFilteredEmployeeList")
    public List<Employee> getFilteredEmployeeList() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    @DgsData(parentType = "Query", field = "getEmployeeId")
    public Optional<Employee> getEmployeeId(@InputArgument int id) {
        Optional<Employee> employees = employeeRepository.findById(id);
        return employees;
    }


}
