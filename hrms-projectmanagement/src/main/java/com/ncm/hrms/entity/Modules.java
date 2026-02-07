package com.ncm.hrms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Modules {
 
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(length = 200)
	
	
	private String description;
	
	 @ManyToOne
	 @JoinColumn(name = "employee_id", nullable = false)
	 private Employee employee;
	 
	 @ManyToOne
	    @JoinColumn(name = "project_id", nullable = false)
	    private Project project;

	 public Modules() {
		super();
	 }

	 public Modules(String name, String description, Employee employee) {
		super();
		this.name = name;
		this.description = description;
		this.employee = employee;
	 }
	 
	 

	 public Modules(String name, String description, Employee employee, Project project) {
		super();
		this.name = name;
		this.description = description;
		this.employee = employee;
		this.project = project;
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

	 public Employee getEmployee() {
		 return employee;
	 }

	 public void setEmployee(Employee employee) {
		 this.employee = employee;
	 }

	 public Project getProject() {
		 return project;
	 }

	 public void setProject(Project project) {
		 this.project = project;
	 }
	 
	 
	
	 
}
