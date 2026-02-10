package com.ncm.hrms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.ncm.hrms.enums.EmpRole;


import com.ncm.hrms.entity.Employee;
import com.ncm.hrms.repository.EmployeeRepository;

@Service
public class AuthService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    public void register(String email, String password) {

        if (employeeRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        Employee emp = new Employee();
        emp.setEmail(email);
        emp.setPassword(passwordEncoder.encode(password));
        emp.setRole(EmpRole.ROLE_EMPLOYEE);

        employeeRepository.save(emp);
    }

    public void login(String email, String password) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(email, password)
        );
    }
}
