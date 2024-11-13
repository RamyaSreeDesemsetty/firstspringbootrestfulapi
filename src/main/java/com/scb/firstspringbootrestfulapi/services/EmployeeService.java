package com.scb.firstspringbootrestfulapi.services;

import java.util.List;

import com.scb.firstspringbootrestfulapi.entities.Employee;

public interface EmployeeService {
	public List<Employee> getAllBooks();

	public Employee getEmployeeById(int bid);

	public Employee createEmployee(Employee emp, int id);

	public void updateEmployeeById(Employee emp, int bId);

	public List<Employee> deleteEmployeeById(int id);
}
