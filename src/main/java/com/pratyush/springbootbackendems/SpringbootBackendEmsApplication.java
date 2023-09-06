package com.pratyush.springbootbackendems;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pratyush.springbootbackendems.model.Employee;
import com.pratyush.springbootbackendems.repository.EmployeeRepository;

@SpringBootApplication
public class SpringbootBackendEmsApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendEmsApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public void run(String... args) throws Exception {
//				Employee emp = new Employee();
//				//emp.setId(1);
//				emp.setFirstname("sol");
//				emp.setLastname("kr");
//			    emp.setEmail("so@gmail.com");
//			    
//			    employeeRepository.save(emp);
////			    
//			    Employee emp2 = new Employee();
//			   // emp2.setId(2);
//				emp2.setFirstname("sol");
//				emp2.setLastname("k");
//			    emp2.setEmail("so@gmail.com");
//			    employeeRepository.save(emp2);
	}
	
	

}
