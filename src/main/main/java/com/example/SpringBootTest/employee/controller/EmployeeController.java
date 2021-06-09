package com.example.SpringBootTest.employee.controller;

import com.example.SpringBootTest.employee.data.Employee;
import com.example.SpringBootTest.employee.data.EmployeeRequest;
import com.example.SpringBootTest.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
        Optional<Employee> existingEmployee = employeeRepository.findOneByName(request.getFirstName(), request.getLastName());

        if(existingEmployee.isPresent()) {
            return new ResponseEntity("Existing Employee", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        Employee employee = employeeRepository.save(Employee.fromRequest(request));

        return ResponseEntity.ok(employee);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> findAll(){
        List<Employee> employeeList = employeeRepository.findAll();

        if(employeeList.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(employeeList);
        }
    }

}
