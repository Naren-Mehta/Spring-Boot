package com.naren.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naren.springboot.cruddemo.dao.EmployeeDAO;
import com.naren.springboot.cruddemo.entity.Employee;
import com.naren.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;

	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}

	@PostMapping("/employees")
	public Employee save(@RequestBody Employee employee) {
		employeeService.save(employee);
		return employee;
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee findById(@PathVariable Integer employeeId) {
		Employee employee= employeeService.findById(employeeId);
		return employee;
	}
	
	@DeleteMapping("/employee/{employeeId}")
	public String deleteById(@PathVariable Integer employeeId) {
		employeeService.deleteById(employeeId);
		return "Employee Deleted with id: "+employeeId;
	}

}
