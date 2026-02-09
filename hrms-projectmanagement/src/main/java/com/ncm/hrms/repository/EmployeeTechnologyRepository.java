package com.ncm.hrms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ncm.hrms.entity.EmployeeTechnology;


@Repository
public interface EmployeeTechnologyRepository extends JpaRepository<EmployeeTechnology, Long> {

List<EmployeeTechnology> findByEmployee_Id(Long employeeId);

boolean existsByEmployee_IdAndTechnology_Id(Long employeeId, Long technologyId);
}

