package com.example.SpringBootTest.employee.repository;

import com.example.SpringBootTest.employee.data.Employee;

import java.util.Optional;

public interface EmployeeRepository {
    Optional<Employee> findOne(String employeeId);

    Employee save(Employee employee);
}
