//package com.ncm.hrms.entity;
//
//import com.ncm.hrms.enums.ProficiencyLevel;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//
//@Entity
//public class EmployeeTechnology {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "employee_id", nullable = false)
//    private Employee employee;
//
//    @ManyToOne
//    @JoinColumn(name = "technology_id", nullable = false)
//    private Technology technology;
//
//    @Column(nullable = false)
//    private Integer experienceInMonths;
//
//    @Enumerated(EnumType.STRING)
//    private ProficiencyLevel proficiency;
//
//	public EmployeeTechnology() {
//		super();
//	}
//
//	public EmployeeTechnology(Employee employee, Technology technology, int experienceInMonths,
//			ProficiencyLevel proficiency) {
//		super();
//		this.employee = employee;
//		this.technology = technology;
//		this.experienceInMonths = experienceInMonths;
//		this.proficiency = proficiency;
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public Employee getEmployee() {
//		return employee;
//	}
//
//	public void setEmployee(Employee employee) {
//		this.employee = employee;
//	}
//
//	public Technology getTechnology() {
//		return technology;
//	}
//
//	public void setTechnology(Technology technology) {
//		this.technology = technology;
//	}
//
//	public int getExperienceInMonths() {
//		return experienceInMonths;
//	}
//
//	public void setExperienceInMonths(int experienceInMonths) {
//		this.experienceInMonths = experienceInMonths;
//	}
//
//	public ProficiencyLevel getProficiency() {
//		return proficiency;
//	}
//
//	public void setProficiency(ProficiencyLevel proficiency) {
//		this.proficiency = proficiency;
//	}
//    
//    
//}
//

package com.ncm.hrms.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ncm.hrms.enums.ProficiencyLevel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class EmployeeTechnology {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    @JsonIgnoreProperties({"technologies", "assignments", "leaveRequests", "password"})  // ✅ Break circular reference
    private Employee employee;
    
    @ManyToOne
    @JoinColumn(name = "technology_id", nullable = false)
    @JsonIgnoreProperties({"employees"})  // ✅ Break circular reference
    private Technology technology;
    
    @Column(nullable = false)
    private Integer experienceInMonths;
    
    @Enumerated(EnumType.STRING)
    private ProficiencyLevel proficiency;
    
    public EmployeeTechnology() {
        super();
    }
    
    public EmployeeTechnology(Employee employee, Technology technology, int experienceInMonths,
            ProficiencyLevel proficiency) {
        super();
        this.employee = employee;
        this.technology = technology;
        this.experienceInMonths = experienceInMonths;
        this.proficiency = proficiency;
    }
    
    // ... getters and setters (keep as is)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }
    public Technology getTechnology() { return technology; }
    public void setTechnology(Technology technology) { this.technology = technology; }
    public int getExperienceInMonths() { return experienceInMonths; }
    public void setExperienceInMonths(int experienceInMonths) { this.experienceInMonths = experienceInMonths; }
    public ProficiencyLevel getProficiency() { return proficiency; }
    public void setProficiency(ProficiencyLevel proficiency) { this.proficiency = proficiency; }
}