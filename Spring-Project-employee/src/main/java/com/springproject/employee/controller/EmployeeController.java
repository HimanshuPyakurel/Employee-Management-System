package com.springproject.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springproject.employee.model.Employee;
import com.springproject.employee.service.DepartmentService;
import com.springproject.employee.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@Autowired
	private DepartmentService deptService;
	
	@GetMapping("/add")
	public String getEmployee(Model model) {
		model.addAttribute("deptlist",deptService.getAllDepts());
		
		return "EmployeeForm";
	}
	
	@PostMapping("/add")
	public String postEmployee(@ModelAttribute Employee emp) {
	
		empService.addEmp(emp);
		return "redirect:/employee/add";
	}
	
	 @GetMapping("/list")
	 public String getlist(Model model) {
		 
		 model.addAttribute("empList",empService.getallEmp());
		 
		 return "EmployeeListForm";
	 }
	
	@GetMapping("/edit")
	public String editEmp(@RequestParam long id, Model model) {
		
		model.addAttribute("empObject", empService.getEmpById(id));
		model.addAttribute("deptlist",deptService.getAllDepts());
		
		return "EmployeeEditForm";
	}
	
	 @PostMapping("/update")
	 public String update(@ModelAttribute Employee emp) {
		 
		 empService.updateEmp(emp);
		 
		 return "redirect:/employee/list"; 
	 }
	 
	 @GetMapping("/delete")
	 public String delete(@RequestParam long id) {
		 	
		 	empService.deleteEmp(id);
		 
		 return "redirect:/employee/list";
	 }
	 
	 @GetMapping("/view")
	 public String view(@RequestParam long id, Model model) {
		 
		 model.addAttribute("empObject",empService.getEmpById(id));
		 model.addAttribute("deptlist",deptService.getAllDepts());
		 return "EmployeeViewForm";
	 }
	 
	
}
