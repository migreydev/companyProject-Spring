package com.jacaranda.EmployeeProjectSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jacaranda.EmployeeProjectSpring.model.Company;
import com.jacaranda.EmployeeProjectSpring.service.CompanyService;

@Controller
public class CompanyController {
	
	@Autowired
	CompanyService companyService;
	
	@GetMapping("/listCompanies")
	public String listCompanies (Model model) {
		List<Company> listCompanies = companyService.getCompanies();
		model.addAttribute("listCompanies", listCompanies);
		return "listCompanies";
	}
	
	@GetMapping("/addCompany")
	public String addCompany(Model model) {
		Company company = new Company();
		model.addAttribute("company", company);
		return "addCompany";
	}
	
	@PostMapping("/addCompany/added")
	public String addedCompany(Model model, @ModelAttribute("company") Company c) {
	    companyService.addCompany(c);
	    String resultado = "The company was added";
	    model.addAttribute("resultado", resultado);
	    
	    return "redirect:/listCompanies";
	}


}
