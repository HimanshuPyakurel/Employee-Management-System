package com.springproject.employee.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springproject.employee.utils.MailUtils;

@Controller
public class ContactController {
	
	@Autowired
	private MailUtils mailutils;
	
	@GetMapping("/contact")
	public String getContact(HttpSession session) {
		
		if(session.getAttribute("validuser") == null) {
			
			return "LoginForm";
		}
		
		return "ContactForm";
	}
	
	@PostMapping("/contact")
	public String postContact(@RequestParam String toEmail,@RequestParam  String subject,@RequestParam  String message) {
		
		mailutils.sendEmail(toEmail,subject,message);
		
		return "ContactForm";
	}
	
}
