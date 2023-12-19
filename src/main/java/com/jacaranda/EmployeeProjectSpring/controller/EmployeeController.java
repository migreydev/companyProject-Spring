package com.jacaranda.EmployeeProjectSpring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacaranda.EmployeeProjectSpring.model.Company;
import com.jacaranda.EmployeeProjectSpring.model.Employee;
import com.jacaranda.EmployeeProjectSpring.service.CompanyService;
import com.jacaranda.EmployeeProjectSpring.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private CompanyService companyService;
	
	@GetMapping("/listEmployees")
	public String listEmployees(Model model, @RequestParam("pageNum") Optional<Integer> pageNum,
	        @RequestParam("pageSize") Optional<Integer> pageSize) {
	    Page<Employee> pageableEmployee = employeeService.findAllPages(pageNum.orElse(1), pageSize.orElse(10));
	    model.addAttribute("currentPage",pageNum.orElse(1));
		model.addAttribute("totalPages",pageableEmployee.getTotalPages());
		model.addAttribute("totalItems",pageableEmployee.getTotalElements());
	    model.addAttribute("pageableEmployee", pageableEmployee);
	    return "listEmployees";
	}


	
	@GetMapping("/addEmployee")
	public String addEmployee (Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		model.addAttribute("listCompanies", companyService.getCompanies());
		return "addEmployee";
	}
	
	@PostMapping("/addEmployee/addedEmployee")
	public String addedEmployee (Model model, @ModelAttribute("employee") Employee e) {
		employeeService.addEmployee(e);
		
		return "redirect:/listEmployees";
		
	}
	

}
