package com.FitnessMembership.FitnessMembership.Repositories.Employees;

import com.FitnessMembership.FitnessMembership.Entities.Employees.Employee;
import com.FitnessMembership.FitnessMembership.Entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
