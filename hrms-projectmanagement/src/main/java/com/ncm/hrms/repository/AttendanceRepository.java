package com.ncm.hrms.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ncm.hrms.entity.Attendance;




@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

	Optional<Attendance> findByEmployeeIdAndDate(Long employeeId, LocalDate date);

	

}
