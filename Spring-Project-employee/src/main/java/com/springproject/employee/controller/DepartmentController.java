package com.springproject.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springproject.employee.model.Department;
import com.springproject.employee.service.DepartmentService;

@Controller
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentService  deptService;
	
	   @GetMapping("/add")
	  public String getDepartment() {
		  
		  return "DepartmentForm";
	  }

	  @PostMapping("/add")
	 public String postDepartment(@ModelAttribute Department  dept) {
		  
		 deptService.addDept(dept);
		  
		 return "DepartmentForm";
	 }
	  
	 @GetMapping("/list")
	 public String deptlist(Model model) {
		 
		 model.addAttribute("deptList",deptService.getAllDepts());
		 
		 return "DepartmentListForm";
	 }
	 
	 @GetMapping("/delete")
	 public String delete(@RequestParam int id) {
		 	
		 	deptService.deleteDept(id);
		 
		 return "redirect:/department/list";
	 }
	 
	 @GetMapping("/edit")
	 public String edit(@RequestParam int id, Model model) {
		 	
		 model.addAttribute("deptObject",deptService.getDeptById(id));
		 
		 return "DepartmentEditForm";
	 }
	 
	 @PostMapping("/update")
	 public String update(@ModelAttribute Department dept) {
		 
		 deptService.updateDept(dept);
		 
		 return "redirect:/department/list"; 
	 }
	 
	 @GetMapping("/view")
	 public String view(@RequestParam int id, Model model) {
		 	
		 model.addAttribute("deptObject",deptService.getDeptById(id));
		 
		 return "DepartmentViewForm";
	 }
	 
}

