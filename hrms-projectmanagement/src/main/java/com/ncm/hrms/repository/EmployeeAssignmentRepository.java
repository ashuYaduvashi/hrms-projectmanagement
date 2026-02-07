package com.ncm.hrms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ncm.hrms.entity.EmployeeAssignment;

public interface EmployeeAssignmentRepository extends JpaRepository<EmployeeAssignment, Long> {

List<EmployeeAssignment> findByProject_ProjectId(Long projectId);
}
