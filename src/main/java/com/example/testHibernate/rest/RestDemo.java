package com.example.testHibernate.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testHibernate.model.Employee;
import com.example.testHibernate.service.HibernateService;

@RestController
public class RestDemo {
	
	@Autowired
	HibernateService hibernateService;

	@GetMapping("/getEmp")
	public Employee getEmployee() {
		
		return new Employee("Teja","Bangalore");
		
	}
	
	@GetMapping("/getEmpDB")
	public Employee getEmployeeFromDB() {
		
		return hibernateService.getEmployee();
		
	}
	
	@GetMapping("/addEmp")
	public void addEmployee() {
		hibernateService.addEmployee(new Employee("Yogender","Mineapolis"));		
	}
}
