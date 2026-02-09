package com.ncm.hrms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ncm.hrms.dto.request.LeaveRequestDto;
import com.ncm.hrms.dto.response.LeaveResponseDto;
import com.ncm.hrms.service.LeaveRequestService;

@RestController
@RequestMapping("/api/leaves")
public class LeaveRequestController {

    private final LeaveRequestService leaveRequestService;

    public LeaveRequestController(LeaveRequestService leaveRequestService) {
        this.leaveRequestService = leaveRequestService;
    }

    @PostMapping("/apply")
    public ResponseEntity<LeaveResponseDto> applyLeave(
            @RequestParam String employeeEmail,
            @RequestBody LeaveRequestDto leaveRequestDto) {

        LeaveResponseDto response =
                leaveRequestService.applyLeave(employeeEmail, leaveRequestDto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{leaveId}/approve")
    public ResponseEntity<LeaveResponseDto> approveLeave(
            @PathVariable Long leaveId) {

        LeaveResponseDto response =
                leaveRequestService.approveLeave(leaveId);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{leaveId}/reject")
    public ResponseEntity<LeaveResponseDto> rejectLeave(
            @PathVariable Long leaveId) {

        LeaveResponseDto response =
                leaveRequestService.rejectLeave(leaveId);

        return ResponseEntity.ok(response);
    }
}
