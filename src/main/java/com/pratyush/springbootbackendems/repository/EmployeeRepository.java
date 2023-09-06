package com.pratyush.springbootbackendems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pratyush.springbootbackendems.model.Employee;

//no need to add @Repository here as spring data jpa internally take care of it
public interface EmployeeRepository  extends JpaRepository<Employee , Long>{
//All CRUD database methods
}
