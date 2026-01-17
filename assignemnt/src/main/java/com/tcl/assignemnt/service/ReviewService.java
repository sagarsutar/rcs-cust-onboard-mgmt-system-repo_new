package com.tcl.assignemnt.service;
 
import org.springframework.stereotype.Service;

import com.tcl.assignemnt.dto.ReviewRequestDTO;
 
import com.tcl.assignemnt.model.FormSubmission;
 

 
public interface ReviewService {
	public FormSubmission review(Long submissionId, ReviewRequestDTO dto);

}