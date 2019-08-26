package com.naren.springboot.cruddemo.dao;

import java.util.List;

import com.naren.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> findAll();
	
	public Employee findById(int id);

	public void save(Employee emp);

	public void deleteById(int id);


}
