package com.spring.veeru.service;

import java.util.List;

import com.spring.veeru.models.Employee;



/**
 * @author virupaksha.kuruva
 *
 */
public interface EmployeeService {

    public List<Employee> findAllEmployee();

    public Employee updateById(Employee employee);

    public Employee findEmployeeById(int Id);

    public Employee saveEmployee(Employee employee);

    public int deleteEmployeeById(Employee employee);
}
