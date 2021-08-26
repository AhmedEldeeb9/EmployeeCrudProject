package com.MyEmployee.Employee.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyEmployee.Employee.dao.EmployeeRepo;
import com.MyEmployee.Employee.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepo employeeRepo;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepo theEmployeeRepository) {
		employeeRepo = theEmployeeRepository;
	}
	
	@Override
	public List<Employee> findAll() {
		return employeeRepo.findAllByOrderByLastNameAsc();
	}

	@Override
	public Employee findById(int theId) {
		Optional<Employee> result = employeeRepo.findById(theId);
		
		Employee theEmployee = null;
		
		if (result.isPresent()) {
			theEmployee = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + theId);
		}
		
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		employeeRepo.save(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		employeeRepo.deleteById(theId);
	}

}






