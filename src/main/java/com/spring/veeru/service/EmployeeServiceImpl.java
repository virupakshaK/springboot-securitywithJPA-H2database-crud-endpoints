package com.spring.veeru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.veeru.dao.EmployeeDAO;
import com.spring.veeru.exceptions.EmptyInputExecption;
import com.spring.veeru.models.Employee;

/**
 * @author virupaksha.kuruva
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeDAO employeeDAO;
	
/*	 @Autowired
	    public EmployeeServiceImpl(@Qualifier("employeeDAOJpaImpl") EmployeeDAO empDao){
		 employeeDAO = empDao;
	    }*/
	
	@Override
	@Transactional
	public List<Employee> findAllEmployee() {
		
		return employeeDAO.findAllEmployee();
	}

	@Override
	public Employee updateById(Employee employee) {
		
		return employeeDAO.updateEmployee(employee);
	}

	@Override
	@Transactional
	public Employee findEmployeeById(int Id) {
		return employeeDAO.findEmployeeById(Id);
	}

	@Override
	@Transactional
	public Employee saveEmployee(Employee employee) {

		if (isEmpty(employee.getFirstName()) == true || isEmpty(employee.getLastName()) == true)
			throw new EmptyInputExecption(400, "Empty data field passed.");
		
		return employeeDAO.saveEmployee(employee);
	}

	@Override
	public int deleteEmployeeById(Employee employee) {
		
		return employeeDAO.deleteEmployeeById(employee);
	}

	
	public boolean isEmpty(String text) {
		if(text == null) {
			return true;
		}else if("".equals(text)) {
			return true;
		}else {
			return false;
		}
	}
}
