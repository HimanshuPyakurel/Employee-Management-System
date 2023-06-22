package com.springproject.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
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
		private IUserService  userService;
		
		@GetMapping("/login")
		public String getLogin() {
			
			return "LoginForm";
		}
		
		@PostMapping("/login")
		public String postLogin(@ModelAttribute User user, Model model) {
			
			user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
			User  usr = userService.login(user.getUsername(), user.getPassword());
			
			if(usr != null) {
				
				model.addAttribute("user",usr);
				
				return "Home";
			}
			model.addAttribute("message","user not found!!");
			return  "LoginForm";
		}
		
		
		@GetMapping("/signup")
		public String getSignup() {
			
			return "SignupForm";
		}
		
		@PostMapping("/signup")
		public String postSignup(@ModelAttribute User user) {
			
			user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
			userService.signup(user);
			
			return "LoginForm";
		}	
		
		
	}
