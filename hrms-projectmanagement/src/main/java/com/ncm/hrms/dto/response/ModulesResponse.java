package com.ncm.hrms.dto.response;

public class ModulesResponse {
	   private Long id;
	    private String name;
	    private String description;

	    private Long projectId;
	    private String projectName;

	    private Long employeeId;
	    private String employeeName;
	    
	    
		public ModulesResponse() {
			super();
		}
		public ModulesResponse(Long id, String name, String description, Long projectId, String projectName,
				Long employeeId, String employeeName) {
			super();
			this.id = id;
			this.name = name;
			this.description = description;
			this.projectId = projectId;
			this.projectName = projectName;
			this.employeeId = employeeId;
			this.employeeName = employeeName;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Long getProjectId() {
			return projectId;
		}
		public void setProjectId(Long projectId) {
			this.projectId = projectId;
		}
		public String getProjectName() {
			return projectName;
		}
		public void setProjectName(String projectName) {
			this.projectName = projectName;
		}
		public Long getEmployeeId() {
			return employeeId;
		}
		public void setEmployeeId(Long employeeId) {
			this.employeeId = employeeId;
		}
		public String getEmployeeName() {
			return employeeName;
		}
		public void setEmployeeName(String employeeName) {
			this.employeeName = employeeName;
		}
	    
	    
}
