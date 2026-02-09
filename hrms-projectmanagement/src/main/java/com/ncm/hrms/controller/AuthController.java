package com.ncm.hrms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.ncm.hrms.entity.Employee;
import com.ncm.hrms.enums.EmpRole;
import com.ncm.hrms.repository.EmployeeRepository;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    
    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestParam String email,
            @RequestParam String password) {

        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(email, password)
        );

        return ResponseEntity.ok("Login successful for " + authentication.getName());
    }

    
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Employee employee) {

        employee.setPassword(passwordEncoder.encode(employee.getPassword()));

       
        if (employee.getRole() == null) {
            employee.setRole(EmpRole.ROLE_EMPLOYEE);
        }

        employeeRepository.save(employee);

        return ResponseEntity.ok("Employee registered successfully");
    }
}
