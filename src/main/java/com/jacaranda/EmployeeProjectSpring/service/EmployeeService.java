package com.jacaranda.EmployeeProjectSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.jacaranda.EmployeeProjectSpring.model.Employee;
import com.jacaranda.EmployeeProjectSpring.repository.EmployeeRepository;
	
	@Service
	public class EmployeeService {
		
		@Autowired
		private EmployeeRepository employeeRepository;
		
		
		
		public Page<Employee> findAllPages(int pageNum, int pageSize) {
		    Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
		    return employeeRepository.findAll(pageable);
		}


		
		
		public List<Employee> getEmployees(){
			return employeeRepository.findAll();
		}
		
		public Employee addEmployee(Employee employee) {
			return employeeRepository.save(employee);
		}
		
		
		
		
		

}
