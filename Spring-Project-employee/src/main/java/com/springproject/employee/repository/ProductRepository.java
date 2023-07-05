package com.springproject.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.employee.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
