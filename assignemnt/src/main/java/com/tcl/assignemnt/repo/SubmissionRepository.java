package com.tcl.assignemnt.repo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcl.assignemnt.model.FormSubmission;
import com.tcl.assignemnt.model.SubmissionStatus;

@Repository
public interface SubmissionRepository extends JpaRepository<FormSubmission, Long> {
 FormSubmission  findByCustomerId(String customerId);
 FormSubmission  findByStatus(SubmissionStatus status);
List<FormSubmission> findByCreatedAtBetween( LocalDateTime startDate, LocalDateTime endDate);
List<FormSubmission> findByCustomerIdAndCreatedAtBetween(String customerId,LocalDateTime startDate,LocalDateTime endDate);
}