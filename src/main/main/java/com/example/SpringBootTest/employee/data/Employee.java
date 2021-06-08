package com.example.SpringBootTest.employee.data;

import com.googlecode.jmapper.annotations.JMap;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "Employee")
public class Employee {

    @Id
    private String id;

    @JMap
    private String firstName;

    @JMap
    private String lastName;

    @JMap
    private BigDecimal wage;

    public String getId() {
        return id;
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

    public BigDecimal getWage() {
        return wage;
    }

    public void setWage(BigDecimal wage) {
        this.wage = wage;
    }

}
