package com.ncm.hrms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ncm.hrms.entity.EmployeeTechnology;

public interface EmployeeTechnologyRepository extends JpaRepository<EmployeeTechnology, Long> {

List<EmployeeTechnology> findByEmployee_Id(Long employeeId);

boolean existsByEmployee_IdAndTechnology_Id(Long employeeId, Long technologyId);
}

