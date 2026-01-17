package com.tcl.assignemnt.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcl.assignemnt.dto.ReviewRequestDTO;
import com.tcl.assignemnt.exception.ResourceNotFoundException;
import com.tcl.assignemnt.model.AuditLog;
import com.tcl.assignemnt.model.FormSubmission;
import com.tcl.assignemnt.repo.AuditRepository;
import com.tcl.assignemnt.repo.SubmissionRepository;

@Service
public class ReviewServiceImpl implements ReviewService{
	
	@Autowired
	private SubmissionRepository submissionRepository;


	@Autowired
	private AuditRepository auditRepository;

	@Override
	public FormSubmission review(Long submissionId, ReviewRequestDTO dto) {
		FormSubmission submission = submissionRepository.findById(submissionId)
	.orElseThrow(() -> new ResourceNotFoundException("Submission not found"));


	submission.setStatus(dto.getStatus());
	submissionRepository.save(submission);


	AuditLog log = new AuditLog();
	log.setSubmissionId(submissionId);
	log.setAction(dto.getStatus().name());
	log.setRemarks(dto.getRemarks());
	log.setActionAt(LocalDateTime.now());
	auditRepository.save(log);


	return submission;
	}

	
	 

}
