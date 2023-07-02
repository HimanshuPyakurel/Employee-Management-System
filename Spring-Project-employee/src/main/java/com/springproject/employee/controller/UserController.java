package com.springproject.employee.controller;

import javax.servlet.http.HttpSession;

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

import lombok.extern.java.Log;

@Log
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
		public String postLogin(@ModelAttribute User user, Model model, HttpSession session) {
			
			user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
			User  usr = userService.login(user.getUsername(), user.getPassword());
			
			if(usr != null) {
				
				log.info("---------- Login Success ---------");
				
				session.setAttribute("validuser", usr);
				session.setMaxInactiveInterval(200);
				
				//model.addAttribute("user",usr);
				
				return "Home";
			}
			
			log.info("---------- Login Failed ---------");
			model.addAttribute("message","user not found!!");
			return  "LoginForm";
		}
		
		
		@GetMapping("/signup")
		public String getSignup() {
			
			return "SignupForm";
		}
		
		@PostMapping("/signup")
		public String postSignup(@ModelAttribute User user) {
			
			log.info("---------- SignUp Success ---------");
			
			user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
			userService.signup(user);
			
			return "LoginForm";
		}	
		
		@GetMapping("/logout")
		public String Logout(HttpSession session) {
			
			log.info("---------- User logout Success ---------");
			
			session.invalidate();	//session kill
			
			return "LoginForm";
		}
		
		 @GetMapping("/home")
		 public String Home() {
			 return "Home";
		 }
		 
		 @GetMapping("/profile")
		 public String getProfile() {
			 
			 return "Profile";
		 }
		
	}
