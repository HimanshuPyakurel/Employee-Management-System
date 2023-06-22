package com.springproject.employee.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.employee.model.User;
import com.springproject.employee.repository.UserRepository;
import com.springproject.employee.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public void signup(User user) {
		userRepo.save(user);
	}

	@Override
	public User login(String un, String psw) {
		 
		return userRepo.findByUsernameAndPassword(un, psw);
	}

	@Override
	public User isUserExist(String un) {
		 
		return userRepo.findByUsername(un);
	}

}
