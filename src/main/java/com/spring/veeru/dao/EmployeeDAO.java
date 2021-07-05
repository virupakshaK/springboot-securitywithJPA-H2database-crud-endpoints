package com.spring.veeru.dao;

import java.util.List;

import com.spring.veeru.models.Employee;


/**
 * @author virupaksha.kuruva
 *
 */
public interface EmployeeDAO {

	 public List<Employee> findAllEmployee();

	    public Employee updateEmployee(Employee employee);

	    public Employee findEmployeeById(int Id);

	    public Employee saveEmployee(Employee employee);

	    public int deleteEmployeeById(Employee employee);
}
