package com.springproject.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.employee.model.Department;


public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
