package com.example.SpringBootTest.employee.repository;

import com.example.SpringBootTest.employee.data.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Optional<Employee> findOne(String employeeId) {
        return Optional.ofNullable(mongoTemplate.findById(employeeId, Employee.class));
    }

    @Override
    public Employee save(Employee employee) {
        return mongoTemplate.save(employee);
    }
}
