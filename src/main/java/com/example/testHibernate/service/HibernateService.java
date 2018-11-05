package com.example.testHibernate.service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testHibernate.model.Employee;

@Service
public class HibernateService {
	@Autowired
	EntityManager entityManager;

	@Transactional(Transactional.TxType.REQUIRES_NEW)
	public void addEmployee(Employee emp) {
		entityManager.persist(emp);		
	}
	
	public Employee getEmployee() {
		Query query = entityManager.createQuery("from Employee");
		Employee emp = (Employee)query.getResultList().get(0);
		return emp;
		
	}
}
