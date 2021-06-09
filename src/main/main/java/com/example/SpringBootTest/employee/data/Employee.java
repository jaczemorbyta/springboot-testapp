package com.example.SpringBootTest.employee.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "Employee")
public class Employee {

    @Id
    private String id;

    private Person person;
    private BigDecimal wage;

    public static Employee fromRequest(EmployeeRequest request) {
        Employee employee = new Employee();
        employee.setPerson(Person.fromRequest(request));
        employee.setWage(request.getWage());

        return employee;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public BigDecimal getWage() {
        return wage;
    }

    public void setWage(BigDecimal wage) {
        this.wage = wage;
    }

    private static class Person {

        private String firstName;
        private String lastName;

        public static Person fromRequest(EmployeeRequest request) {
            Person person = new Person();
            person.setFirstName(request.getFirstName());
            person.setLastName(request.getLastName());

            return person;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

    }
}
