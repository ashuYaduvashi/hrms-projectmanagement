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

    // Fetch all employees for admin
    public List<EmployeeResponse> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(this::mapEmployeeToResponse)
                .collect(Collectors.toList());
    }
    
    // Map Employee entity to EmployeeResponse DTO
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

        // Directly set Address entities
        response.setCurrentAddress(employee.getCurrentAddress());
        response.setPermanentAddress(employee.getPermanentAddress());

        // Map designation if present
        if (employee.getDesignation() != null) {
            DesignationResponse dr = new DesignationResponse();
            dr.setId(employee.getDesignation().getId());
            dr.setTitle(employee.getDesignation().getTitle());
            response.setDesignation(dr);
        }

        // Map technologies if present
        response.setTechnologies(
                employee.getTechnologies() == null
                        ? Collections.emptyList()
                        : employee.getTechnologies().stream()
                            .map(t -> {
                                EmployeeTechnologyResponse tr = new EmployeeTechnologyResponse();
                                tr.setId(t.getId());
                                tr.setTechnologyName(t.getTechnology().getName());
                                tr.setExperienceInMonths(t.getExperienceInMonths());
                                tr.setProficiency(t.getProficiency());
                                return tr;
                            }).collect(Collectors.toList())
        );

        // Directly set assignments and leave requests
        response.setAssignments(employee.getAssignments());
        response.setLeaveRequests(employee.getLeaveRequests());

        return response;
    }
}
