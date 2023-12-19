package com.jacaranda.EmployeeProjectSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
	public String listEmployees (Model model) {
		List<Employee> listEmployee = employeeService.getEmployees();
		model.addAttribute("listEmployee", listEmployee);
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
