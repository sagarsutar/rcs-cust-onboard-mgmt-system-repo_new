package com.tcl.assignemnt.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcl.assignemnt.dto.SubmissionRequestDTO;
import com.tcl.assignemnt.exception.ResourceNotFoundException;
import com.tcl.assignemnt.model.Form;
import com.tcl.assignemnt.model.FormSubmission;
import com.tcl.assignemnt.model.SubmissionStatus;
import com.tcl.assignemnt.repo.FormRepository;
import com.tcl.assignemnt.repo.SubmissionRepository;
import com.tcl.assignemnt.validation.JsonSchemaValidationClass;

@Service
public class SubmissionServiceImpl implements SubmissionService{
	
	@Autowired
	private SubmissionRepository submissionRepository;


	@Autowired
	private FormRepository formRepository;

	@Override
	public FormSubmission submitForm(SubmissionRequestDTO dto) {
	Form form = formRepository.findById(dto.getFormId())
	.orElseThrow(() -> new ResourceNotFoundException("Form not found"));

	 
	
	FormSubmission submission = new FormSubmission();
	submission.setCustomerId(dto.getCustomerId());
	submission.setForm(form);
	submission.setResponseJson(dto.getResponseJson());
	
	JsonSchemaValidationClass.validateAgainstSchema(submission);
	
	if("DRAFT".equalsIgnoreCase(dto.getSubmissionStatus())) {
	 submission.setStatus(SubmissionStatus.SUBMITTED);
	}else if("APPROVED".equalsIgnoreCase(dto.getSubmissionStatus())) {
		 submission.setStatus(SubmissionStatus.APPROVED);
	}else if("IN_REVIEW".equalsIgnoreCase(dto.getSubmissionStatus())) {
		 submission.setStatus(SubmissionStatus.IN_REVIEW);
	}else if("REJECTED".equalsIgnoreCase(dto.getSubmissionStatus())) {
		 submission.setStatus(SubmissionStatus.REJECTED);
	}else   {
		 submission.setStatus(SubmissionStatus.DRAFT);
	} 
	return submissionRepository.save(submission);
	}

 


	@Override
	public FormSubmission getByCustomer(String customerId) {
	 
		return submissionRepository.findByCustomerId(customerId); 
	}


	@Override
	public FormSubmission getByStatus(SubmissionStatus submissionStatus) {
	 
		return submissionRepository.findByStatus(submissionStatus); 
	}

	// CUSTOMER specific date filter
	@Override
	public List<FormSubmission> getByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
		 
		 return submissionRepository.findByCreatedAtBetween(startDate, endDate);
	}



	@Override
	public List<FormSubmission> getCustomerSubmissionsByDateandId(String customerId, LocalDateTime startDate,
			LocalDateTime endDate) {
		return submissionRepository.findByCustomerIdAndCreatedAtBetween(customerId, startDate, endDate);
	}

 
}
