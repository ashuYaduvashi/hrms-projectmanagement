package com.ncm.hrms.dto.request;

import com.ncm.hrms.enums.ProficiencyLevel;

public class EmployeeTechnologyRequest {

	   private Long technologyId;
	    private Integer experienceInMonths;
	    private ProficiencyLevel proficiency;

	    public EmployeeTechnologyRequest() {
	    }

		public Long getTechnologyId() {
			return technologyId;
		}

		public void setTechnologyId(Long technologyId) {
			this.technologyId = technologyId;
		}

		public Integer getExperienceInMonths() {
			return experienceInMonths;
		}

		public void setExperienceInMonths(Integer experienceInMonths) {
			this.experienceInMonths = experienceInMonths;
		}

		public ProficiencyLevel getProficiency() {
			return proficiency;
		}

		public void setProficiency(ProficiencyLevel proficiency) {
			this.proficiency = proficiency;
		}
	    
	    
	    
}
