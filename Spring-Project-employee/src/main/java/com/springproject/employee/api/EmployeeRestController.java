package com.springproject.employee.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springproject.employee.model.Employee;
import com.springproject.employee.service.EmployeeService;

@RestController
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/api/emp/list")
	public List<Employee> getAll() {
		
		return empService.getallEmp();
		
	}
	
	@GetMapping("/api/emp/{id}")
	public Employee getOneEmp(@PathVariable Long id) {
		return empService.getEmpById(id);
	}
	
	@PostMapping("/api/emp/add")
	public String add(@RequestBody Employee emp) {
		empService.addEmp(emp);
		return "success";
	}
	
	@PutMapping("/api/emp/update")
	public String update(@RequestBody Employee emp) {
		empService.updateEmp(emp);
		return "update success";
	}
	
	@PutMapping("/api/emp/delete/{id}")
	public String delete(@PathVariable Long id) {
		empService.deleteEmp(id);
		return "delete success";
	}
	
	@GetMapping("/api/emp/j2o")
	public String jsonToObjectMapping() {
		
		RestTemplate temp = new RestTemplate();
		Employee e = temp.getForObject("http://localhost/api/emp/2", Employee.class);
		
		return "FirstName =" +e.getFname();
	}
	

	
}
