package com.springproject.employee.service;

import java.util.List;

import com.springproject.employee.model.Employee;

public interface EmployeeService {
	
	void addEmp(Employee e);
	
	void deleteEmp(long id);
	
	void updateEmp(Employee e);
	
	Employee getEmpById(long id);
	
	List<Employee> getallEmp();
}
