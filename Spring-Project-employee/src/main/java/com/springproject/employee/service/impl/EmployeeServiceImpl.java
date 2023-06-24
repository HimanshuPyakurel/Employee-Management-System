package com.springproject.employee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.employee.model.Employee;
import com.springproject.employee.repository.EmployeeRepository;
import com.springproject.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository empRepo;
	
	@Override
	public void addEmp(Employee e) {
		empRepo.save(e);
	}

	@Override
	public void deleteEmp(int id) {
		empRepo.deleteById(id);
	}

	@Override
	public void updateEmp(Employee e) {
		empRepo.save(e);
	}

	@Override
	public Employee getEmpById(int id) {
		
		return empRepo.findById(id).get();
	}

	@Override
	public List<Employee> getallEmp() {
		
		return empRepo.findAll();
	}

	
}
