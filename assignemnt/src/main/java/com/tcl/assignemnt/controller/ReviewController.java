package com.tcl.assignemnt.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcl.assignemnt.dto.ReviewRequestDTO;
import com.tcl.assignemnt.model.FormSubmission;
import com.tcl.assignemnt.service.ReviewService;


/***
 * this is created to review the forms 
 * @author Sagar
 *
 */

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {


@Autowired
private ReviewService reviewService;


@PostMapping("/{id}")
public ResponseEntity<FormSubmission> review(
@PathVariable("id") Long id,
@RequestBody ReviewRequestDTO dto) {
	
return ResponseEntity.ok(reviewService.review(id, dto));

}
}