package com.example.SpringBootTest.employee.data;

import com.googlecode.jmapper.annotations.JMap;

import java.math.BigDecimal;

public class EmployeeRequest {

    @JMap
    private String firstName;

    @JMap
    private String lastName;

    @JMap
    private BigDecimal wage;

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
