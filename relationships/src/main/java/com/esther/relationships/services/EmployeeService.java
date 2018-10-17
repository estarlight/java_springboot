package com.esther.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.esther.relationships.models.Employee;
import com.esther.relationships.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	private EmployeeRepository employeeRepo;
	
	public EmployeeService (EmployeeRepository employeeRepo) {
		this.employeeRepo = employeeRepo;
	}
	
	public Employee findEmployee(Long id) {
		
		Optional<Employee> employee = employeeRepo.findById(id);
		if (employee.isPresent()) {
			return employee.get();
	
		} else {
			return null;
		}
	}
	
	
	public void findManager(Employee employee) {
		Employee manager = employee.getManager();
		System.out.println(employee + "'s manager is " + manager);
		
	}
	
	public void findEmployees(Employee employee) {
		List<Employee> employeeList = employee.getEmployees();
		for (Employee e : employeeList) {
			System.out.print(e.getFirstName() + e.getLastName());
		}
	}
	


		
}
