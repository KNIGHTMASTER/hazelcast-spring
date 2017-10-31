package com.zisal.hazelcast_spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zisal.hazelcast_spring.model.Employee;
import com.zisal.hazelcast_spring.service.EmployeeServiceImpl;
import com.zisal.hazelcast_spring.service.IEmployeeService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        /*Employee employee = new Employee();
        employee.setName("Employee 1");
        employee.setRole("Role 1");
        IEmployeeService employeeService = (EmployeeServiceImpl) context.getBean(EmployeeServiceImpl.class);
        employeeService.insert(employee);      */   
    }
}
