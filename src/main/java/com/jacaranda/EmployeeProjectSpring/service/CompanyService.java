package com.jacaranda.EmployeeProjectSpring.service;

import java.util.List;
import java.util.Optional;

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
	
	public Company findIdCompany(Integer id) {
		return companyRepository.findById(id).orElse(null);
		
	}
	
	public Company updateCompany(Company updatedCompany) {
		return companyRepository.save(updatedCompany);
		
	}
	
	public void deleteCompany(Company deleteCompany) {

	    	companyRepository.delete(deleteCompany);
	    
	}



	

}
