package com.example.Practice.service;

import com.example.Practice.constants.ConfigConstants;
import com.example.Practice.mapper.ReqresResponseMapper;
import com.example.Practice.model.Employee;
import com.example.Practice.model.EmployeeInput;
import com.example.Practice.model.FinanceDetails;
import com.example.Practice.model.UserDataResponse;
import com.example.Practice.repository.EmployeeRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@CircuitBreaker(name = ConfigConstants.CIRCUIT_BREAKER_NAME)
public class EmployeeGraphqlServiceImpl implements EmployeeGraphqlService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private UserDataServiceImpl userDataService;

    @Autowired
    private ReqresResponseMapper reqresResponseMapper;

    @Override
    public List<Employee> getAllEmployeeData() {
        List<Employee> employees = employeeRepository.findAll();
        if (!CollectionUtils.isEmpty(employees)) {
            return employees;
        } else {
            throw new RuntimeException("No Records Founds in Database...Please try again later");
        }
    }

    @Override
    public List<EmployeeInput> createEmployees(List<EmployeeInput> employees) {
        if (!CollectionUtils.isEmpty(employees)) {
            List<EmployeeInput> employee = employeeRepository.saveAll(employees.stream().map(employeeInput -> new EmployeeInput()).collect(Collectors.toList()));
            return employee;
        } else {
            throw new RuntimeException("Error while saving Employee Data!!. Kindly provide data ");
        }

    }

    public List<Employee> getFilteredEmployeesEmail() {
        UserDataResponse response = userDataService.getUserData();
        List<Employee> employees = employeeRepository.findAll();

        if (!CollectionUtils.isEmpty(employees)) {
            List<Employee> list = employees.stream().filter(filtered -> response.getUserDataList().stream().anyMatch(email -> email.getEmail().equals(filtered.getEmail()))).collect(Collectors.toList());
            List<Employee> filteredList = reqresResponseMapper.userDataResponseMapper(response, list);
            return filteredList;
        }
        else {
            throw new RuntimeException("No content");
        }
    }

    @Override
    public Optional<Employee> getEmployeeById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (!Objects.isNull(employee) && employeeRepository.existsById(id)) {
            return employee;
        } else {
            throw new RuntimeException("Employee with id: " + id + " don't exist in the database...");
        }
    }

    @Override
    public void deleteById(int id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);

        } else {
            throw new RuntimeException("Provided id: " + id + " is invalid or doesn't exist in the database...");
        }
    }

    @Override
    public Employee updateEmployee(int id, Employee employee) {
        Employee emp = employeeRepository.findById(id).get();

        if (!Objects.isNull(emp)) {
            emp.setFirstName(employee.getFirstName());
            emp.setLastName(employee.getLastName());
            emp.setAge(employee.getAge());
            emp.setCompanyName(employee.getCompanyName());

            FinanceDetails financeDetails = new FinanceDetails();
            financeDetails.setGrade(employee.getFinanceDetails().getGrade());
            financeDetails.setRole(employee.getFinanceDetails().getRole());
            financeDetails.setSalary(employee.getFinanceDetails().getSalary());

            emp.setFinanceDetails(financeDetails);
            employeeRepository.save(emp);
        } else {
            throw new RuntimeException("Error while updating Employee data of id: " + id + "Try again!!");
        }

        return emp;
    }
}
