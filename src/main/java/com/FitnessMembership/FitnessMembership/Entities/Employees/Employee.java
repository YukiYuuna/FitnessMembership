package com.FitnessMembership.FitnessMembership.Entities.Employees;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    private String firstName;

    private String lastName;

    private String Email;

    private String corporateNum;

    private long roleId;

    public Employee(String firstName, String lastName, String email, String corporateNum, long roleId) {
        this.firstName = firstName;
        this.lastName = lastName;
        Email = email;
        this.corporateNum = corporateNum;
        this.roleId = roleId;
    }

    public Employee() {
    }

    public Long getId() {
        return Id;
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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getCorporateNum() {
        return corporateNum;
    }

    public void setCorporateNum(String corporateNum) {
        this.corporateNum = corporateNum;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }
}
