package com.ncm.hrms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ncm.hrms.entity.Employee;
import com.ncm.hrms.entity.LeaveRequest;
import com.ncm.hrms.enums.LeaveStatus;


@Repository
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {

List<LeaveRequest> findByEmployee_Id(Long employeeId);
List<LeaveRequest> findByEmployee(Employee employee);

List<LeaveRequest> findByLeaveStatus(LeaveStatus status);

List<LeaveRequest> findByEmployeeAndLeaveStatus(Employee employee, LeaveStatus status);
}

