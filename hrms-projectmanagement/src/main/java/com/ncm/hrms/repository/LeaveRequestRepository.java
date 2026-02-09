package com.ncm.hrms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ncm.hrms.entity.Employee;
import com.ncm.hrms.entity.LeaveRequest;
import com.ncm.hrms.enums.LeaveStatus;

public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {

List<LeaveRequest> findByEmployee_Id(Long employeeId);

Optional<Employee> findByEmployee(Employee employee);

Optional<Employee> findByLeaveStatus(LeaveStatus pending);
}

