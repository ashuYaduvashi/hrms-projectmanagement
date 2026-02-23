package com.ncm.hrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ncm.hrms.dto.request.EmployeeRequest;
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
    
    @GetMapping("/empById/{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable Long id){
    	return ResponseEntity.ok(adminService.getEmployeeById(id));
    }
    
    @PutMapping("/updateEmp/{id}")
    public EmployeeResponse updateEmployee(
            @PathVariable Long id,
            @RequestBody EmployeeRequest request) {
        return adminService.updateEmployee(id, request);
    }
}
