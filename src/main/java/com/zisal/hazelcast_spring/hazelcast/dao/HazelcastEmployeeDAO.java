package com.zisal.hazelcast_spring.hazelcast.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hazelcast.core.MapStore;
import com.zisal.hazelcast_spring.dao.EmployeeDAO;
import com.zisal.hazelcast_spring.model.Employee;

@Component("employeeCacheDao")
public class HazelcastEmployeeDAO implements MapStore<Long, Employee>{

	@Autowired
	EmployeeDAO employeeDAO;
	
	public Employee load(Long arg0) {		
		return employeeDAO.findOne(arg0);
	}

	public Map<Long, Employee> loadAll(Collection<Long> map) {		
		Map<Long, Employee> employeeMap = new HashMap<Long, Employee>();
        List<Employee> employees = employeeDAO.findAll();
        for (Employee employee : employees) {
            employeeMap.put(employee.getId(), employee);
        }
        return employeeMap;
	}

	public void delete(Long arg0) {
		employeeDAO.delete(arg0);
	}

	public void deleteAll(Collection<Long> arg0) {
		for (Iterator<Long> iterator = arg0.iterator(); iterator.hasNext();){
			delete(iterator.next());
		}
	}

	public void store(Long arg0, Employee arg1) {
		employeeDAO.save(arg1);
	}

	public void storeAll(Map<Long, Employee> map) {
		for (Map.Entry<Long, Employee> mapEntry : map.entrySet()) {
            store(mapEntry.getKey(), mapEntry.getValue());
        }
	}

	public Set<Long> loadAllKeys() {
		Map<Long, Employee> employeeMap = new HashMap<Long, Employee>();
        List<Employee> employees = employeeDAO.findAll();
        for (Employee employee : employees) {
            employeeMap.put(employee.getId(), employee);
        }
        return employeeMap.keySet();
	}

}
