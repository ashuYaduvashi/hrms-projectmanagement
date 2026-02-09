package com.ncm.hrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ncm.hrms.entity.Employee;
import com.ncm.hrms.repository.EmployeeRepository;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
