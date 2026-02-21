package com.ncm.hrms.service;

import org.springframework.stereotype.Service;

import com.ncm.hrms.dto.request.EmployeeTechnologyRequest;
import com.ncm.hrms.entity.Employee;
import com.ncm.hrms.entity.EmployeeTechnology;
import com.ncm.hrms.entity.Technology;
import com.ncm.hrms.repository.EmployeeRepository;
import com.ncm.hrms.repository.EmployeeTechnologyRepository;
import com.ncm.hrms.repository.TechnologyRepository;


@Service
public class EmployeeTechnologyService {

	 private final EmployeeTechnologyRepository empTechRepo;
	    private final TechnologyRepository techRepo;
	    private final EmployeeRepository empRepo;
	    

	public EmployeeTechnologyService(EmployeeTechnologyRepository empTechRepo, TechnologyRepository techRepo,
				EmployeeRepository emprepo) {
			super();
			this.empTechRepo = empTechRepo;
			this.techRepo = techRepo;
			this.empRepo = emprepo;
		}



	public void addTechnologyByEmail(String email, EmployeeTechnologyRequest request) {

        Employee employee = empRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        Technology technology = techRepo.findById(request.getTechnologyId())
                .orElseThrow(() -> new RuntimeException("Technology not found"));

        EmployeeTechnology empTech = new EmployeeTechnology();
        empTech.setEmployee(employee);
        empTech.setTechnology(technology);
        empTech.setExperienceInMonths(request.getExperienceInMonths());
        empTech.setProficiency(request.getProficiency());
        empTech.setUsageDescription(request.getUsageDescription());

        empTechRepo.save(empTech);
    }
}
