package com.example.Practice.service;

import com.example.Practice.mapper.ReqresResponseMapper;
import com.example.Practice.model.Employee;
import com.example.Practice.model.FinanceDetails;
import com.example.Practice.model.UserData;
import com.example.Practice.model.UserDataResponse;
import com.example.Practice.repository.EmployeeRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private UserDataServiceImpl userDataService;

    @Autowired
    private ReqresResponseMapper reqresResponseMapper;

    @Autowired
    private ObjectMapper objectMapper;
    public ResponseEntity getAllEmployeeData() {
        List<Employee> employees = employeeRepository.findAll();
        if (!CollectionUtils.isEmpty(employees)) {
            return ResponseEntity.of(Optional.of(employees));
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("No Records Founds in Database...Please try again later");
        }
    }

    public ResponseEntity getFilteredEmployeesEmail() {
        UserDataResponse response = userDataService.getUserData();
        List<Employee> employees = employeeRepository.findAll();

        if (!CollectionUtils.isEmpty(employees)) {
            List<Employee> list = employees.stream().filter(filtered -> response.getUserDataList().stream().anyMatch(email -> email.getEmail().equals(filtered.getEmail()))).collect(Collectors.toList());
            List<Employee> filteredList = reqresResponseMapper.userDataResponseMapper(response, list);
            return ResponseEntity.ok(filteredList);
        }
        else {
            return ResponseEntity.noContent().build();
        }
    }

    public ResponseEntity createEmployees(List<Employee> employees) {

        if (!CollectionUtils.isEmpty(employees)) {
            List<Employee> employee = employeeRepository.saveAll(employees);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Employee record created successfully..");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error while saving Employee Data!!. Kindly provide data ");
        }
    }

    public ResponseEntity getEmployeeById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (!Objects.isNull(employee) && employeeRepository.existsById(id)) {
            return ResponseEntity.of(Optional.of(employee));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Employee with id: " + id + " don't exist in the database...");
        }
    }

    public ResponseEntity deleteById(int id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Employee record deleted successfully...");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Provided id: " + id + " is invalid or doesn't exist in the database...");
        }
    }

    public ResponseEntity updateEmployee(int id, Employee employee) {
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
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error while updating Employee data of id: " + id + "Try again!!");
        }
        return ResponseEntity.of(Optional.of(emp));
    }
}
