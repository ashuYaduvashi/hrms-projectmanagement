package com.ncm.hrms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ncm.hrms.entity.EmployeeAssignment;
import com.ncm.hrms.entity.Project;

public interface EmployeeAssignmentRepository extends JpaRepository<EmployeeAssignment, Long> {

List<EmployeeAssignment> findByProject_ProjectId(Long projectId);

Optional<Project> findByProject(Project project);
}
