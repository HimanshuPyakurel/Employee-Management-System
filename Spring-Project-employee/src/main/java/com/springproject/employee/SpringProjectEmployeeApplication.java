package com.springproject.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Employee Rest API", version = "4.0", description = "employee CRUD apis"))
public class SpringProjectEmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringProjectEmployeeApplication.class, args);
	}

}
