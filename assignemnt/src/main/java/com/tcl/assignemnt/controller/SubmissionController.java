package com.tcl.assignemnt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcl.assignemnt.dto.SubmissionRequestDTO;
import com.tcl.assignemnt.model.FormSubmission;
import com.tcl.assignemnt.model.SubmissionStatus;
import com.tcl.assignemnt.service.SubmissionService;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
/****
 * This is created for submission of the form
 * @author Sagar
 *
 */
@RestController
@RequestMapping("/api/submissions")
public class SubmissionController {


@Autowired
private SubmissionService submissionService;


@PostMapping("/submit")
public ResponseEntity<FormSubmission> submit(@RequestBody SubmissionRequestDTO dto) {
return ResponseEntity.ok(submissionService.submitForm(dto));
}


 

 
    @PreAuthorize("hasRole('CUSTOMER') or hasRole('ADMIN')")
    @GetMapping("/customer/{customerId}")
    public  FormSubmission  getByCustomer(
            @PathVariable("customerId") String customerId) {
        return submissionService.getByCustomer(customerId);
    }

 
    @PreAuthorize("hasAnyRole('CUSTOMER','TPM','SALES','ADMIN')")
    @GetMapping("/status")
    public  FormSubmission  getByStatus(
    		@RequestParam("status") SubmissionStatus status) {
        return submissionService.getByStatus(status);
    }

    
    @PreAuthorize("hasAnyRole('TPM','ADMIN')")
    @GetMapping("/date-range")
    public List<FormSubmission> getByDateRange(
            @RequestParam("startDate")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime startDate,

            @RequestParam("endDate")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime endDate
    ) {
        return submissionService.getByDateRange(startDate, endDate);
    }

   
    @PreAuthorize("hasRole('CUSTOMER')")
    @GetMapping("/customer/{customerId}/date-range")
    public List<FormSubmission> getCustomerByDateRange(
            @PathVariable("customerId") String customerId,
            @RequestParam("startDate")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime startDate,
            @RequestParam("endDate")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime endDate
    ) {
        return submissionService
                .getCustomerSubmissionsByDateandId(customerId, startDate, endDate);
    }
}




 