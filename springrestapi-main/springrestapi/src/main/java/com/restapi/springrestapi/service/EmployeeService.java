package com.restapi.springrestapi.service;

import java.util.List;
import java.util.Optional;

import com.restapi.springrestapi.entity.Employee;

public interface EmployeeService {
	
	List<Employee> getEmployees(int pageNumber, int pageSize);
	
	Employee saveEmployee(Employee employee);
	
	Employee getEmployee(Long id);
	
	void deleteEmployee(Long id);
	
	Employee updateEmployee(Employee employee);
	
	List<Employee> getEmployeeByName(String name);
	
	List<Employee> getEmployeeByNameAndLocation(String name, String location);
	
	List<Employee> getEmployeeByKeyword(String keyword);
	
	List<Employee> getEmployeeByAgeGreaterThan(Integer age);
	
	List<Employee> getEmployeeByAgeBetween(Integer ageFrom, Integer ageTo);
	
	List<Employee> getEmployeeByNameOrLocation(String name, String location);
	
	Integer deleteEmployeeByName(String name);

}
