package com.example.SpringBootTest.employee.repository;

import com.example.SpringBootTest.employee.data.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
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

    @Override
    public List<Employee> findAll() {
        return mongoTemplate.findAll(Employee.class);
    }

    @Override
    public Optional<Employee> findOneByName(String firstName, String lastName) {
        return Optional.ofNullable(
                mongoTemplate.findOne(Query.query(Criteria
                            .where("firstName").is(firstName)
                            .andOperator(Criteria.where("lastName").is(lastName)))
                , Employee.class)
        );
    }
}
