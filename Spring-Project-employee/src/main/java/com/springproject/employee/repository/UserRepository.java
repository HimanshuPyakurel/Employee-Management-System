package com.springproject.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.employee.model.User;

public interface UserRepository  extends JpaRepository<User, Integer>{

	User findByUsernameAndPassword(String un, String psw);
	
	User findByUsername(String un);
	
	User findByEmail(String email);
	
	void save(String pwd);
}
