package com.springproject.employee.service;

import com.springproject.employee.model.User;

public interface IUserService {

	void signup(User user);
	User login(String un,String psw);
	User isUserExist(String un);
	
}
