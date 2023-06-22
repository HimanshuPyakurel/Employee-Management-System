package com.springproject.employee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.employee.model.Department;
import com.springproject.employee.repository.DepartmentRepository;
import com.springproject.employee.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	@Autowired
	private DepartmentRepository  deptRepo;

	@Override
	public void addDept(Department dept) {
		deptRepo.save(dept);
	}

	@Override
	public void deleteDept(int id) {
		deptRepo.deleteById(id);
	}

	@Override
	public void updateDept(Department dept) {
		deptRepo.save(dept);
	}

	@Override
	public Department getDeptById(int id) {
		 
		return deptRepo.findById(id).get();
	}

	@Override
	public List<Department> getAllDepts() {
		 
		return deptRepo.findAll();
	}

}
