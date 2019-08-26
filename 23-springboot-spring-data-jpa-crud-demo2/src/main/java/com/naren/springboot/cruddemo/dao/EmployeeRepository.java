package com.naren.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naren.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
