package com.pratyush.springbootbackendems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratyush.springbootbackendems.exception.ResourceNotFoundException;
import com.pratyush.springbootbackendems.model.Employee;
import com.pratyush.springbootbackendems.repository.EmployeeRepository;

@CrossOrigin("*")
//@CrossOrigin("http://localhost:3000/")
@RestController
@RequestMapping("/api/v1/employees") //base url for all rest methods
public class EmployeeController {

	@Autowired 
	private EmployeeRepository employeeRepository ;
	
	//Get All Employee REST API
	@GetMapping
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	
	//Create New Employee REST API
	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee)//requestBody convert json to java object
	{
		return employeeRepository.save(employee);
	}
	
	
	//Find Employee By ID REST API
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){ //pathvariable bind the value of id to the method arguments
		Employee emp =  employeeRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException("Employee do not exist with id : " + id));
				return ResponseEntity.ok(emp);
	}
	
	
	//Update Employee REST API
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable long id ,@RequestBody Employee employeeDetails){ //pathvariable bind the value of id to the method arguments
		Employee emp =  employeeRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException("Employee do not exist with id : " + id));
				
		emp.setFirstname(employeeDetails.getFirstname());
		emp.setLastname(employeeDetails.getLastname());
		emp.setEmail(employeeDetails.getEmail());
		
		employeeRepository.save(emp);
		return ResponseEntity.ok(emp);
	}
	
	
	//Delete Employee By ID REST API
	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id ){ //pathvariable bind the value of id to the method arguments
		Employee emp =  employeeRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException("Employee do not exist with id : " + id));
				
		
		employeeRepository.delete(emp);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	
}
