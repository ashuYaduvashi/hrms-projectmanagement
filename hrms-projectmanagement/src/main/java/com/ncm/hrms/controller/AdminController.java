package com.ncm.hrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ncm.hrms.dto.response.EmployeeResponse;
import com.ncm.hrms.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/employees")
    public List<EmployeeResponse> getAllEmployees() {
        return adminService.getAllEmployees();
    }
}
