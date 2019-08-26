package com.naren.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.naren.springboot.cruddemo.dao.EmployeeRepository;
import com.naren.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		this.employeeRepository = theEmployeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int id) {
		Optional<Employee> result = employeeRepository.findById(id);

		Employee theEmployee = null;
		if (result.isPresent()) {
			theEmployee = result.get();
		} else {
			// we are not able to find employee
			throw new RuntimeException("Not able to find Employee with id " + id);
		}

		return theEmployee;
	}

	@Override
	public void save(Employee emp) {
		employeeRepository.save(emp);
	}

	@Override
	public void deleteById(int id) {
		employeeRepository.deleteById(id);
	}

}
