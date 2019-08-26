package com.naren.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naren.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		this.entityManager = theEntityManager;
	}


	@Override
	@Transactional
	public List<Employee> findAll() {
		Session session= entityManager.unwrap(Session.class);
		Query<Employee> query = session.createQuery("from Employee " , Employee.class);
		List<Employee> employeeList= query.getResultList();
		return employeeList;
	}

}
