package com.ncm.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ncm.hrms.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}

