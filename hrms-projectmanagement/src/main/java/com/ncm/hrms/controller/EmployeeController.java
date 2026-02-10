package com.ncm.hrms.controller;


import org.springframework.web.bind.annotation.*;
import com.ncm.hrms.dto.response.EmployeeResponse;
import com.ncm.hrms.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public EmployeeResponse getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployee(id);
    }
}
