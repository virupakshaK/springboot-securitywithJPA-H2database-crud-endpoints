package com.spring.veeru.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.veeru.models.Employee;


/**
 * @author virupaksha.kuruva
 *
 */
@Repository
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO{

	@Autowired
	 private EntityManager entityManager;
	 
	/* @Autowired
    public EmployeeDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;

    }*/
	  //get all the employees from the database
	@Override
	public List<Employee> findAllEmployee() {
		  Query theQuery= (Query) entityManager.createQuery("from employee");
	        @SuppressWarnings("unchecked")
			List<Employee> employees = theQuery.getResultList();

	        return employees;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		if(entityManager.find(Employee.class, employee.getId()) != null) {
			return  entityManager.merge(employee);
		}
		return null;
	}

	@Override
	public Employee findEmployeeById(int Id) {
		Employee employee = entityManager.find(Employee.class,Id);
	        return employee;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
			entityManager.persist(employee);
			System.out.println(employee.toString());
		   return employee; //entityManager.merge(employee);
	}
	
	//add the transaction to the database
	@Override
	public int deleteEmployeeById(Employee employee) {
		try {
			if (entityManager.find(Employee.class, employee.getId()) != null) {
				employee = entityManager.find(Employee.class, employee.getId());
				entityManager.remove(employee);
			}
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

}
