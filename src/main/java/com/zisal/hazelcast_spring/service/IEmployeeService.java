package com.zisal.hazelcast_spring.service;

import java.util.List;

import com.zisal.hazelcast_spring.model.Employee;

public interface IEmployeeService {

	List<Employee> findAllEmployee();
	
	Employee find(Long p_Id);
	
	void insert(Employee p_Employee);
	
	void delete(Long p_Id);
	
	void update(Employee p_Employee);
}
