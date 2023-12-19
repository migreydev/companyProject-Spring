package com.jacaranda.EmployeeProjectSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacaranda.EmployeeProjectSpring.model.Employee;
import com.jacaranda.EmployeeProjectSpring.repository.EmployeeRepository;
	
	@Service
	public class EmployeeService {
		
		@Autowired
		private EmployeeRepository employeeRepository;
		
		
		public List<Employee> getEmployees(){
			return employeeRepository.findAll();
		}
		
		public Employee addEmployee(Employee employee) {
			return employeeRepository.save(employee);
		}

}
