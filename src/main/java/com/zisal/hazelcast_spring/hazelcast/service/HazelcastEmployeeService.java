package com.zisal.hazelcast_spring.hazelcast.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.zisal.hazelcast_spring.dao.EmployeeDAO;
import com.zisal.hazelcast_spring.model.Employee;
import com.zisal.hazelcast_spring.service.IEmployeeService;

@Service
public class HazelcastEmployeeService implements IEmployeeService {

	@Autowired
	HazelcastInstance hazelcastInstance;

	@Autowired
	EmployeeDAO employeeDAO;

	private IMap<Long, Employee> dataStore;
	
	private static final String EMPLOYEE_MAP = "employeeMap";

	public List<Employee> findAllEmployee() {
		dataStore = hazelcastInstance.getMap(EMPLOYEE_MAP);
		return new ArrayList<Employee>(dataStore.values());
	}

	public Employee find(Long p_Id) {
		dataStore = hazelcastInstance.getMap(EMPLOYEE_MAP);
		return dataStore.get(p_Id);
	}

	public void insert(Employee p_Employee) {
		dataStore = hazelcastInstance.getMap(EMPLOYEE_MAP);
        dataStore.put(p_Employee.getId(), p_Employee);
	}

	public void delete(Long p_Id) {
		 dataStore = hazelcastInstance.getMap(EMPLOYEE_MAP);
	     dataStore.remove(p_Id);
	}

	public void update(Employee p_Employee) {
		// TODO Auto-generated method stub
	}
	
	public void shutDown(){
        hazelcastInstance.getLifecycleService().shutdown();
    }

}
