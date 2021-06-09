package com.example.SpringBootTest.employee.repository;

import com.example.SpringBootTest.employee.data.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    Optional<Employee> findOne(String employeeId);

    Employee save(Employee employee);

    List<Employee> findAll();

    Optional<Employee> findOneByName(String firstName, String lastName);
}
