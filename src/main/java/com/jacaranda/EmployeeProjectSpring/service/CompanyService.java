package com.jacaranda.EmployeeProjectSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacaranda.EmployeeProjectSpring.model.Company;
import com.jacaranda.EmployeeProjectSpring.repository.CompanyRepository;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	
	public List<Company> getCompanies(){
		return companyRepository.findAll();
	}
	
	public Company addCompany(Company c) {
		return companyRepository.save(c);
	}

}
