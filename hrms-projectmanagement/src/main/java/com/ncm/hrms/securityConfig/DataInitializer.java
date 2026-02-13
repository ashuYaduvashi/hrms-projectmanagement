package com.ncm.hrms.securityConfig;

import com.ncm.hrms.entity.Employee;
import com.ncm.hrms.enums.EmpRole;
import com.ncm.hrms.repository.EmployeeRepository;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void createAdmin() {

        if (employeeRepository.findByEmail("admin@gmail.com").isEmpty()) {

            Employee admin = new Employee();
            admin.setName("Admin");
            admin.setEmail("admin@gmail.com");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRole(EmpRole.ROLE_ADMIN);

            employeeRepository.save(admin);

            System.out.println("Default Admin Created!");
        }
    }
}
