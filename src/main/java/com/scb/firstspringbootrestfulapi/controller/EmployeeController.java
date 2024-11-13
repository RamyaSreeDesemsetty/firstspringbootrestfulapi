package com.scb.firstspringbootrestfulapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scb.firstspringbootrestfulapi.entities.Employee;
import com.scb.firstspringbootrestfulapi.services.EmployeeServiceImpl;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;

	// Get all employees
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employees = employeeServiceImpl.getAllEmployees();
		if (employees.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.ok(employees);
		}
	}

	// Get employee by id
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int empId) {
		Employee employee = employeeServiceImpl.getEmployeeById(empId);
		if (employee == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			return ResponseEntity.ok(employee);
		}
	}

	// Create employee
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		Employee createdEmployee = employeeServiceImpl.createEmployee(employee);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
	}

	// Update employee by id
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployeeById(@PathVariable("id") int empId, @RequestBody Employee employee) {
		employeeServiceImpl.updateEmployeeById(employee, empId);
		return ResponseEntity.ok(employee);
	}

	// Delete employee by id
	@DeleteMapping("/{id}")
	public ResponseEntity<List<Employee>> deleteEmployeeById(@PathVariable("id") int empId) {
		List<Employee> updatedEmployees = employeeServiceImpl.deleteEmployeeById(empId);
		return ResponseEntity.ok(updatedEmployees);
	}
}

