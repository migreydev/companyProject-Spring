package com.jacaranda.EmployeeProjectSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.EmployeeProjectSpring.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
	
	
	

}


