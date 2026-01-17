package com.tcl.assignemnt.service;

 
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tcl.assignemnt.dto.SubmissionRequestDTO;
import com.tcl.assignemnt.model.FormSubmission;
import com.tcl.assignemnt.model.SubmissionStatus;
 

 
public interface SubmissionService {
	public FormSubmission submitForm(SubmissionRequestDTO dto);
	public  FormSubmission getByCustomer(String customerId);
    public FormSubmission getByStatus(SubmissionStatus submissionStatus);
    public List<FormSubmission>getByDateRange( LocalDateTime  startDate,LocalDateTime endDate);
    public List<FormSubmission> getCustomerSubmissionsByDateandId(String customerId,LocalDateTime startDate,LocalDateTime endDate);
}