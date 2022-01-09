package com.FitnessMembership.FitnessMembership.Entities.Employees;

import javax.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role;

    private String firstName;

    private String lastName;

    private String Email;

    private String corporateNum;

    public Employee(String firstName, String lastName, String email, String corporateNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.Email = email;
        this.corporateNum = corporateNum;
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

}
