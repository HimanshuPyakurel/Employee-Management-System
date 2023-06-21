package com.springproject.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springproject.employee.model.User;
import com.springproject.employee.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService userservice;
	
	@GetMapping("/login")
	public String getLogin() {
		return "LoginForm";
	}
	
	@PostMapping("/login")
	public String postLogin(@ModelAttribute User user) {
		
		User usr= userservice.login(user.getUsername(), user.getPassword());
		
		if(usr != null) {
			return "Home";
		}
		return "LoginForm";
	}
	
	
	
}
