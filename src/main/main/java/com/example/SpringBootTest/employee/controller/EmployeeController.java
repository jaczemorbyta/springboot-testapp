package com.example.SpringBootTest.employee.controller;

import com.example.SpringBootTest.employee.data.Employee;
import com.example.SpringBootTest.employee.data.EmployeeRequest;
import com.example.SpringBootTest.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("employeeId") String employeeId) {
        Optional<Employee> employee = employeeRepository.findOne(employeeId);

        if(employee.isPresent()) {
            return ResponseEntity.ok(employee.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody EmployeeRequest request) {
        Employee employee = employeeRepository.save(new Employee(request));

        return ResponseEntity.ok(employee);
    }

}
