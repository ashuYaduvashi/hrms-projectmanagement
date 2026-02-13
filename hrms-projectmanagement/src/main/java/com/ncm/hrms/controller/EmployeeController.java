package com.ncm.hrms.controller;


import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.ncm.hrms.dto.request.EmployeeRequest;
import com.ncm.hrms.dto.response.EmployeeResponse;
import com.ncm.hrms.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/profile")
    public EmployeeResponse getProfile(Authentication authentication) {
        return employeeService.getEmployeeProfile(authentication);
    }

    @PutMapping("/profile")
    public EmployeeResponse updateProfile(Authentication authentication,
                                          @RequestBody EmployeeRequest request) {
        return employeeService.updateEmployeeProfile(authentication, request);
    }
}


