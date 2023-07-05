package com.springproject.employee.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Rating {
	
	@Id
	@GeneratedValue
	private int id;
	private double rate;
	private int count;
}
