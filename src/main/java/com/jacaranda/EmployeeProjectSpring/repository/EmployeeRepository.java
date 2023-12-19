package com.jacaranda.EmployeeProjectSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.EmployeeProjectSpring.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
