package com.restapi.springrestapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.restapi.springrestapi.entity.Employee;

@Repository
//public interface EmployeeRepository extends JpaRepository<Employee, Long> {
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
	

	List<Employee> findByName(String name);
	
	List<Employee> findByNameAndLocation(String name, String location);
	
	List<Employee> findByNameContaining(String keyword, Sort sort);
	
	
	//SELECT * FROM tbl_employee WHERE age > 20;
	List<Employee> findByAgeGreaterThan(int age);
	
	//SELECT * FROM tbl_employee WHERE age BETWEEN 20 AND 30;
	List<Employee> findByAgeBetween(int ageFrom, int ageTo);
	
	
	@Query("FROM Employee WHERE name= :name OR location =:location")
	List<Employee> findEmployeeByNameOrLocation(String name, String location);
	
	
	@Modifying
	@Transactional
	@Query("DELETE FROM Employee WHERE name =:name")
	Integer deleteEmployeeByName(String name);
	
	
	Employee save(Employee employee);
	void deleteById(Long id);
	Optional<Employee> findById(Long id);
	
	@Query(value ="select * from tbl_employee", nativeQuery = true)
	List<Employee> getAllEmployees();
	
}
