package com.naren.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naren.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		Query query= entityManager.createQuery("from Employee");
		List<Employee> emplList = query.getResultList();
		return emplList;
	}

	@Override
	public Employee findById(int id) {
		Employee employee=entityManager.find(Employee.class, id);
		return employee;
	}

	@Override
	public void save(Employee emp) {
		System.out.println("====emp===="+emp);
		Employee dbEmployee = entityManager.merge(emp);
		emp.setId(dbEmployee.getId());
	}

	@Override
	public void deleteById(int id) {
		
		Query query= entityManager.createQuery("delete from Employee where id=:empId");
		query.setParameter("empId", id);
		query.executeUpdate();
	}

}
