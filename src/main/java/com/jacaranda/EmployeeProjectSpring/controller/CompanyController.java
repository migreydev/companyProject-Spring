package com.jacaranda.EmployeeProjectSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		
		// Agrega la compañia al modelo para que pueda ser utilizada en el form
		model.addAttribute("company", company);
		return "addCompany";
	}
	
	@PostMapping("/addCompany/added")
	public String addedCompany(Model model, @ModelAttribute("company") Company c) {
		
		//Añade a la compañia
	    companyService.addCompany(c);
	    String resultado = "The company was added";
	    model.addAttribute("resultado", resultado);
	    
	    // Redirige a la URL "/listCompanies"
	    return "redirect:/listCompanies";
	}
	
	@GetMapping("/updateCompany")
	public String updateCompany(Model model, @RequestParam("id") int companyId) {
	    Company company = companyService.findIdCompany(companyId);
	    model.addAttribute("company", company);
	    return "updateCompany";
	}


	@PostMapping("/updateCompany/updated")
	public String updatedCompany(@ModelAttribute("company") Company updatedCompany) {
		Company companyId = companyService.findIdCompany(updatedCompany.getId());
		
		if(companyId != null) {
			companyService.updateCompany(updatedCompany);
			return "redirect:/listCompanies";
		} else {
			return "updateCompany";
		}
	}

	
	@GetMapping("/deleteCompany")
	public String deleteCompany(Model model, @RequestParam("id") int companyId) {
	    
	    Company company = companyService.findIdCompany(companyId);
	    model.addAttribute("company", company);
	    return "deleteCompany";
	}
	
	@PostMapping("/deleteCompany/deleted")
	public String deletedCompany(@ModelAttribute("company") Company deleteCompany) {
		Company companyId = companyService.findIdCompany(deleteCompany.getId());
		
		if(companyId != null) {
			companyService.deleteCompany(deleteCompany);
			return "redirect:/listCompanies";
		} else {
			return "deleteCompany";
		}
	}


	
}
