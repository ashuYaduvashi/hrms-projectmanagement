package com.ncm.hrms.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncm.hrms.dto.response.DesignationResponse;
import com.ncm.hrms.dto.response.EmployeeResponse;
import com.ncm.hrms.dto.response.EmployeeTechnologyResponse;
import com.ncm.hrms.entity.Employee;
import com.ncm.hrms.repository.EmployeeRepository;

@Service
public class AdminService {

    @Autowired
    private EmployeeRepository employeeRepository;

   
    public List<EmployeeResponse> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(this::mapEmployeeToResponse)
                .collect(Collectors.toList());
    }
    
    public EmployeeResponse getEmployeeById(Long id) {
    	Employee emp=employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Employee not found"));
    	return mapEmployeeToResponse(emp);
    }
    
   
    private EmployeeResponse mapEmployeeToResponse(Employee employee) {
        EmployeeResponse response = new EmployeeResponse();

        response.setId(employee.getId());
        response.setName(employee.getName());
        response.setEmail(employee.getEmail());
        response.setPhoneNumber(employee.getPhoneNumber());
        response.setEducation(employee.getEducation());
        response.setHireDate(employee.getHireDate());
        response.setCreatedAt(employee.getCreatedAt());
        response.setStatus(employee.getStatus());
        response.setSameAsPermanent(employee.isSameAsPermanent());

        response.setCurrentAddress(employee.getCurrentAddress());
        response.setPermanentAddress(employee.getPermanentAddress());

        if (employee.getDesignation() != null) {
            DesignationResponse dr = new DesignationResponse();
            dr.setId(employee.getDesignation().getId());
            dr.setTitle(employee.getDesignation().getTitle());
            response.setDesignation(dr);
        }

        
        response.setTechnologies(
                employee.getTechnologies() == null
                        ? Collections.emptyList()
                        : employee.getTechnologies().stream()
                            .map(t -> {
                                EmployeeTechnologyResponse tr = new EmployeeTechnologyResponse();
                                tr.setTechnologyId(t.getTechnology().getId());
                                tr.setExperienceInMonths(t.getExperienceInMonths());
                                tr.setProficiency(t.getProficiency());
                                tr.setUsageDescription(t.getUsageDescription());
                                return tr;
                            }).collect(Collectors.toList())
        );

       
        response.setAssignments(employee.getAssignments());
        response.setLeaveRequests(employee.getLeaveRequests());

        return response;
    }
}
