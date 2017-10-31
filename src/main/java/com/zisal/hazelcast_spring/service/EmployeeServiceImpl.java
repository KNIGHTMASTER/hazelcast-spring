package com.zisal.hazelcast_spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.zisal.hazelcast_spring.dao.EmployeeDAO;
import com.zisal.hazelcast_spring.model.Employee;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	EmployeeDAO employeeDao;
	
	public List<Employee> findAllEmployee() {
		return employeeDao.findAll();
	}

	public Employee find(Long p_Id) {
		return employeeDao.findOne(p_Id);
	}

	public void insert(Employee p_Employee) {
		employeeDao.save(p_Employee);
	}

	public void delete(Long p_Id) {
		employeeDao.delete(p_Id);
	}

	public void update(Employee p_Employee) {
		employeeDao.save(p_Employee);
	}

}
