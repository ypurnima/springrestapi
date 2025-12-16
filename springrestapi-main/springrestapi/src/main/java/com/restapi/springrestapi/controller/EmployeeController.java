package com.restapi.springrestapi.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.springrestapi.entity.Employee;
import com.restapi.springrestapi.repository.EmployeeRepository;
import com.restapi.springrestapi.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
//@RequestMapping("/api")--this will define in properties file
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Value("${app.name: EMS}")
	private String appName;
	
	@Value("${app.version: v1.0}")
	private String appVersion;
	
	@GetMapping("version")
	public String getAppDetails() {
		return "The App Name : "+appName +" App Version :"+appVersion ;
	}


	//with pagination
	@GetMapping("/employees") 
	public ResponseEntity<List<Employee>>  getEmployees(@RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
		System.out.println("Fetching List of Employees...");
		return new ResponseEntity<List<Employee>> (employeeService.getEmployees(pageNumber, pageSize), HttpStatus.OK);
	}
	
	
	@GetMapping("/get-all-employees") //this will use SQL Native Query method in JPA
	public ResponseEntity<List<Employee>>  getEmployees() {
		System.out.println("Fetching List of Employees...Using Native Query methods in JPA...");
		return new ResponseEntity<List<Employee>> (employeeRepository.getAllEmployees(), HttpStatus.OK);//direct access repository layer.
	}
	
	
	@PostMapping("/employees")
	public ResponseEntity<Employee>  saveEmployee(@Valid @RequestBody Employee employee) {
		System.out.println("Save new Employee...");
		return new ResponseEntity<Employee> (employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable() Long id) {
		System.out.println("Fetching Single Employee...");
		return new ResponseEntity<Employee>(employeeService.getEmployee(id), HttpStatus.OK);
	}
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
		((Object) employee).setId(id);
		System.out.println("Updating Employee...");
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee), HttpStatus.OK); 
	}
	
	@GetMapping("/employee/searchByName")
	public ResponseEntity<List<Employee>> getEmployeeByName(@RequestParam String name){
		return new ResponseEntity<List<Employee>>(employeeService.getEmployeeByName(name), HttpStatus.OK);
	}
	
	@GetMapping("/employee/searchByNameAndLocation")
	public ResponseEntity<List<Employee>> getEmployeeByNameAndLocation(@RequestParam String name, @RequestParam String location){
		return new ResponseEntity<List<Employee>>(employeeService.getEmployeeByNameAndLocation(name, location), HttpStatus.OK);
	}
	
	@GetMapping("/employee/{name}/{location}")//using @PathaVariable
	public ResponseEntity<List<Employee>> getEmployeeByNameAndLocation2(@PathVariable String name, @PathVariable String location){
		return new ResponseEntity<List<Employee>>(employeeService.getEmployeeByNameAndLocation(name, location), HttpStatus.OK);
	}
	
	
	@GetMapping("/employee/searchByKeyword")
	public ResponseEntity<List<Employee>> getEmployeeByKeyword(@RequestParam String keyword){
		return new ResponseEntity<List<Employee>>(employeeService.getEmployeeByKeyword(keyword), HttpStatus.OK);
	}
	
	
	@GetMapping("/employee/{searchByAgeGreaterThan}") //implemented with pathVariable
	public ResponseEntity<List<Employee>> getEmployeeByAgeGreaterThan(@PathVariable("searchByAgeGreaterThan") int age){
		return new ResponseEntity<List<Employee>>(employeeService.getEmployeeByAgeGreaterThan(age), HttpStatus.OK);
	}
	@GetMapping("/employee/searchByAgeGreaterThan") //implemented with Request Param
	public ResponseEntity<List<Employee>> getEmployeeByAgeGreaterThan2(@RequestParam int age){
		return new ResponseEntity<List<Employee>>(employeeService.getEmployeeByAgeGreaterThan(age), HttpStatus.OK);
	}
	
	@GetMapping("/employee/searchByAgeFromAndAgeTo") //implemented with Request Param
	public ResponseEntity<List<Employee>> getEmployeeByAgeBetween(@RequestParam int ageFrom, @RequestParam int ageTo){
		return new ResponseEntity<List<Employee>>(employeeService.getEmployeeByAgeBetween(ageFrom, ageTo), HttpStatus.OK);
	}
	
	@GetMapping("/employees/{empName}/{empLocation}")
	public ResponseEntity<List<Employee>> getEmployeeByNameOrLocation(@PathVariable("empName") String name, @PathVariable("empLocation") String location){
		return new ResponseEntity<List<Employee>>(employeeService.getEmployeeByNameOrLocation(name, location), HttpStatus.OK);
	}
	
	@DeleteMapping("/employee/delete/{empName}")
	public ResponseEntity<String> deleteEmployeeByName(@PathVariable("empName") String name){
		return new ResponseEntity<String>(employeeService.deleteEmployeeByName(name)+" No. of records deleted! ", HttpStatus.OK);
	}
	
	@DeleteMapping("/employees")
	public ResponseEntity<HttpStatus> deleteEmployees(@RequestParam Long id) {
		System.out.println("Deleting Employee...");
		employeeService.deleteEmployee(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
	


}
