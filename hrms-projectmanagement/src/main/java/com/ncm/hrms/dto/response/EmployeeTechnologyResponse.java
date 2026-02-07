package com.ncm.hrms.dto.response;

import com.ncm.hrms.enums.ProficiencyLevel;

public class EmployeeTechnologyResponse {
	private Long id;

    private Long technologyId;
    private String technologyName;

    private int experienceInMonths;
    private ProficiencyLevel proficiency;

    public EmployeeTechnologyResponse() {
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTechnologyId() {
		return technologyId;
	}

	public void setTechnologyId(Long technologyId) {
		this.technologyId = technologyId;
	}

	public String getTechnologyName() {
		return technologyName;
	}

	public void setTechnologyName(String technologyName) {
		this.technologyName = technologyName;
	}

	public int getExperienceInMonths() {
		return experienceInMonths;
	}

	public void setExperienceInMonths(int experienceInMonths) {
		this.experienceInMonths = experienceInMonths;
	}

	public ProficiencyLevel getProficiency() {
		return proficiency;
	}

	public void setProficiency(ProficiencyLevel proficiency) {
		this.proficiency = proficiency;
	}
    
    
}
