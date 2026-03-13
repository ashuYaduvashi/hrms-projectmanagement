package com.ncm.hrms.entity;

import jakarta.persistence.*;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

@Entity
public class Shift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalTime startTime;

    private LocalTime endTime;

    private LocalTime flexibleStartLimit;


    private Duration requiredWorkHours;

    private Boolean flexible;

    @OneToMany(mappedBy = "shift")
    private List<Employee> employees;
    
    
    

	public Shift() {
		super();
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


	public LocalTime getStartTime() {
		return startTime;
	}


	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}


	public LocalTime getEndTime() {
		return endTime;
	}


	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}


	public LocalTime getFlexibleStartLimit() {
		return flexibleStartLimit;
	}


	public void setFlexibleStartLimit(LocalTime flexibleStartLimit) {
		this.flexibleStartLimit = flexibleStartLimit;
	}


	public Duration getRequiredWorkHours() {
		return requiredWorkHours;
	}


	public void setRequiredWorkHours(Duration requiredWorkHours) {
		this.requiredWorkHours = requiredWorkHours;
	}


	public Boolean getFlexible() {
		return flexible;
	}


	public void setFlexible(Boolean flexible) {
		this.flexible = flexible;
	}


	public List<Employee> getEmployees() {
		return employees;
	}


	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

   
}