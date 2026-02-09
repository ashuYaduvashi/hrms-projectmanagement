package com.ncm.hrms.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ncm.hrms.entity.Project;
import com.ncm.hrms.enums.ProjectStatus;

public interface ProjectRepository extends JpaRepository<Project, Long> {

	Optional<Project> findByStatus(ProjectStatus active);

	
}

