package com.FitnessMembership.FitnessMembership.Entities.Employees;

import javax.persistence.*;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @OneToOne(mappedBy = "role")
    private Employee employee;

    private String Name;

    public Role() {
    }

    public Role(Long id, String name,Employee employee) {
        Id = id;
        Name = name;
        this.employee = employee;
    }

    public Long getId() {
        return Id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}

