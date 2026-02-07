package com.ncm.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ncm.hrms.entity.Designation;

public interface DesignationRepository extends JpaRepository<Designation, Long> {
}

