package com.ncm.hrms.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ncm.hrms.entity.Modules;
import com.ncm.hrms.entity.Project;

@Repository
public interface ModulesRepository {
	 List<Modules> findByProject(Project project);
	    List<Modules> findByProjectProjectId(Long projectId);
}
