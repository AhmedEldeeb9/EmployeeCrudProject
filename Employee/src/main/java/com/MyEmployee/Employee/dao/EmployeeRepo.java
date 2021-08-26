package com.MyEmployee.Employee.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MyEmployee.Employee.entity.Employee;
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    //add a method to sort asc
	public List<Employee> findAllByOrderByLastNameAsc();
}
