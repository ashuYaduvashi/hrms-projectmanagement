//package com.ncm.hrms.securityConfig;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import com.ncm.hrms.entity.Employee;
//import com.ncm.hrms.repository.EmployeeRepository;
// 
//import jakarta.annotation.PostConstruct;
//
//@Component
//public class DefaultEmployee {
//	
//	 @Autowired
//	    private EmployeeRepository employeeRepository;
//	 
//
//	    @Autowired
//	    private PasswordEncoder passwordEncoder;
//	 
//	 
//	 @PostConstruct
//	 public void addDefaultEmployee() {
//		 
//		 Employee emp1 =new Employee();
//		 emp1.setName("Harsh");
//		 emp1.setEmail("harsh1234@gmail.com");
//		 emp1.setPassword(passwordEncoder.encode("Harsh@1234"));
//		 
//		 Employee emp2 =new Employee();
//		 emp2.setName("Anurag");
//		 emp2.setEmail("anurag1234@gmail.com");
//		 emp2.setPassword(passwordEncoder.encode("Anurag@1234"));
//		 
//		employeeRepository.save(emp1);
//		employeeRepository.save(emp2);
//		
//
//		 
//	 }
//
//
//}
