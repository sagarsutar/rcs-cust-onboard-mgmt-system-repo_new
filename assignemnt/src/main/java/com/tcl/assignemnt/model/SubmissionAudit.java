package com.tcl.assignemnt.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "submission_audit")
public class SubmissionAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long submissionId;
    private String oldStatus;
    private String newStatus;
    private String changedBy;
    private String remarks;
    private LocalDateTime changedAt;
}
