package com.springproject.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.employee.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
