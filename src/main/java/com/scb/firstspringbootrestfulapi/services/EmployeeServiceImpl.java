package com.scb.firstspringbootrestfulapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scb.firstspringbootrestfulapi.entities.Employee;
import com.scb.firstspringbootrestfulapi.repositories.EmployeeRepository;
@Service
public class EmployeeServiceImpl {
	@Autowired
	EmployeeRepository empRepo;

		// Get all hotels
		public List<Employee> getAllEmployees() {
			return empRepo.findAll();
		}

		// get emp by id
		public Employee getEmployeeById(int empId) {
			Optional<Employee> optionalEmployee = empRepo.findById(empId);
			return optionalEmployee.orElse(null);
		}

		// create employee
		public Employee createEmployee(Employee emp) {
			return empRepo.save(emp);
		}

		// update employee
		public void updateEmployeeById(Employee emp, int empId) {
			Optional<Employee> optionalEmployee = empRepo.findById(empId);
			if (optionalEmployee.isPresent()) {
				Employee existingEmployee = optionalEmployee.get();
				existingEmployee.setEmpName(emp.getEmpName());
				existingEmployee.setSalary(emp.getSalary());
				empRepo.save(existingEmployee);
			}
		}

		public List<Employee> deleteEmployeeById(int empId) {
			empRepo.deleteById(empId);
			return getAllEmployees(); // Returns the updated list of employees
		}

	}


