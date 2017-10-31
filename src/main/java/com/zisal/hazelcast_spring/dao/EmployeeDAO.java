package com.zisal.hazelcast_spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zisal.hazelcast_spring.model.Employee;

public interface EmployeeDAO extends JpaRepository<Employee, Long> {

}
