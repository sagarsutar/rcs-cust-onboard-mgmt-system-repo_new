package com.tcl.assignemnt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcl.assignemnt.model.AuditLog;

@Repository
public interface AuditRepository extends JpaRepository<AuditLog, Long> {
java.util.List<AuditLog> findBySubmissionId(Long submissionId);
}